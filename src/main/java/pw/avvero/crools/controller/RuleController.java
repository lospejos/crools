package pw.avvero.crools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pw.avvero.crools.analize.DataSet;
import pw.avvero.crools.analize.DataSetExtractor;
import pw.avvero.crools.service.RuleService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Avvero on 21.12.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping(value = "/analise", method = RequestMethod.GET)
    public Object findAllByConversation() throws IOException {
        String feature = "src/main/resources/group_distribution.feature";

        Map result = new HashMap();
        DataSetExtractor rules = new DataSetExtractor();
        DataSet dataSet = ruleService.execute(rules, feature);
        result.put("dataSet", dataSet);
        return result;
    }

}
