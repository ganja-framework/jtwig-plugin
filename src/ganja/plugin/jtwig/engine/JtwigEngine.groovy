package ganja.plugin.jtwig.engine

import com.lyncode.jtwig.JtwigModelMap
import com.lyncode.jtwig.JtwigTemplate
import com.lyncode.jtwig.configuration.JtwigConfiguration
import com.lyncode.jtwig.resource.ClasspathJtwigResource
import ganja.common.http.ResponseInterface
import ganja.common.view.TemplateEngineInterface
import ganja.component.http.Response

class JtwigEngine implements TemplateEngineInterface {

    String prefix = '/views/jtwig/'
    String suffix = '.twig.html'

    @Override
    ResponseInterface render(String template, Object data, ResponseInterface response = null) {

        def resource = new ClasspathJtwigResource("${prefix}${template}${suffix}")
        def rendered = new JtwigTemplate(resource, new JtwigConfiguration()).output(data as JtwigModelMap)

        if(response) {
            return response.setContent(rendered)
        }
        else {
            return new Response(content: rendered)
        }
    }
}
