package acceptance

import acceptance.framework.AcceptanceTestBase
import app.core.models.Contact

import static org.assertj.core.api.Assertions.*

public class ContactsApiSpec extends AcceptanceTestBase {

    def "GET /contacts"() {
        when:
        List<Contact> contacts = get '/api/contacts'

        then:
        assertThat(contacts).extracting({c -> c.id}).contains('1234', '5678')
        assertThat(contacts).extracting({c -> c.name}).contains('Matthew Shaw', 'Taffany Leung')
        assertThat(contacts).extracting({c -> c.email}).contains('shaw500@gmail.com', 'taffanyl@gmail.com')
        assertThat(contacts).extracting({c -> c.username}).contains('mjshaw', 'taffanyl')
    }

    def "GET /contacts/:id"() {
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
}
