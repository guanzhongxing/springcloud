package cn.com.gzx.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TestMongo {

    @Autowired
    private MongoTemplate mongoTemplate;

//    LookupOperation lookupOperation = LookupOperation.newLookup()
//            .from("applyPolicyNoRel")
//            .localField("applyPolicyNo")
//            .foreignField("applyPolicyNo")
//            .as("");
//
//    Aggregation aggregation = Aggregation.newAggregation(
//
//
//    );

}
