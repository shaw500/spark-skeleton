package acceptance

import acceptance.framework.AcceptanceTestBase
import app.core.models.Contact

import static org.assertj.core.api.Assertions.*

public class ContactsApiSpec extends AcceptanceTestBase {

    def 'GET /api/contacts'() {
        when:
        List<Contact> contacts = get '/api/contacts'

        then:
        assertThat(contacts).extracting({c -> c.id}).contains('1234', '5678')
        assertThat(contacts).extracting({c -> c.name}).contains('Matthew Shaw', 'Taffany Leung')
        assertThat(contacts).extracting({c -> c.email}).contains('shaw500@gmail.com', 'taffanyl@gmail.com')
        assertThat(contacts).extracting({c -> c.username}).contains('mjshaw', 'taffanyl')
    }

    def 'GET /api/contacts/:id'() {
        when:
        Contact contact = get '/api/contacts/1234'

        then:
        with(contact) {
            assertThat(id).isEqualTo('1234')
            assertThat(name).isEqualTo('Matthew Shaw')
            assertThat(email).isEqualTo('shaw500@gmail.com')
            assertThat(username).isEqualTo('mjshaw')
        }
    }

    def 'POST /api/contacts'() {
        when:
        Contact original = new Contact('some-id', 'Some Person', 'some-one@some-where.com', 'some-user')
        Contact response = post '/api/contacts', original
        Contact result = get '/api/contacts/some-id'

        then:
        with(response) {
            assertThat(id).isEqualTo('some-id')
            assertThat(name).isEqualTo('Some Person')
            assertThat(email).isEqualTo('some-one@some-where.com')
            assertThat(username).isEqualTo('some-user')
        }
        with(result) {
            assertThat(id).isEqualTo('some-id')
            assertThat(name).isEqualTo('Some Person')
            assertThat(email).isEqualTo('some-one@some-where.com')
            assertThat(username).isEqualTo('some-user')
        }

    }
}
