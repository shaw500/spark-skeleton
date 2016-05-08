package app.api.controllers

import app.api.spark.SparkComponent
import app.core.models.Contact
import app.core.repository.ContactsRepository
import app.utils.JsonMarshaller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static spark.Spark.*

@Component
class ContactsController implements SparkComponent {

    @Autowired
    JsonMarshaller json
    @Autowired
    ContactsRepository repository


    @Override
    void start() {
        get '/api/contacts', { req, res ->
            repository.all()
        }, json

        get '/api/contacts/:id', { req, res ->
            def id = req.params('id')

            def contact = repository.getById(id)
            if(!contact) throw new RuntimeException("Expected contact with id '$id', but found none.")
            contact
        }, json

        post '/api/contacts', { req, res ->
            throw new UnsupportedOperationException('Cannot create contacts yet...')
        }, json
    }
}
