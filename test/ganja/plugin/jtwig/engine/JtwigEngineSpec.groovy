package ganja.plugin.jtwig.engine

import ganja.common.http.ResponseInterface
import ganja.common.view.TemplateEngineInterface
import spock.lang.Specification

class JtwigEngineSpec extends Specification {

    void "it is initializable"() {

        given:
        def subject = new JtwigEngine()

        expect:
        subject instanceof JtwigEngine
        subject instanceof TemplateEngineInterface
    }

    void "it can render template"() {

        given:
        def subject = new JtwigEngine()
        ResponseInterface resp = Mock()

        when:
        ResponseInterface response = subject.render('test', [ name: 'Twig'])

        then:
        response.getContent() == 'Hello Twig!'

        when:
        subject.render('test', [ name: 'Other'], resp)

        then:
        1 * resp.setContent(_)
    }
}
