package ganja.plugin.jtwig

import ganja.common.di.ContainerInterface
import ganja.common.plugin.PluginInterface
import spock.lang.Specification

class JtwigPluginSpec extends Specification {

    void "it is initializable"() {

        given:
        def subject = new JtwigPlugin()

        expect:
        subject instanceof JtwigPlugin
        subject instanceof PluginInterface
    }

    void "it can register services"() {

        given:
        def subject = new JtwigPlugin()
        ContainerInterface container = Mock()

        when:
        subject.registerServices(container)

        then:
        1 * container.register(_,_)
    }
}
