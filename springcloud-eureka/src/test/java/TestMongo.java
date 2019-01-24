import cn.com.gzx.SpringCloudEureka;
import cn.com.gzx.entity.ApplyPolicyCardNoRel;
import cn.com.gzx.entity.ApplyWillDTO;
import cn.com.gzx.entity.BaseInfoDTO;
import cn.com.gzx.entity.ContractDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloudEureka.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMongo {

    private Logger logger = LoggerFactory.getLogger(TestMongo.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertMongoTest() {
        String applyPolicyNo = "333333";
        ApplyWillDTO applyWillDTO = new ApplyWillDTO();
        ContractDTO contractDTO = new ContractDTO();
        BaseInfoDTO baseInfoDTO = new BaseInfoDTO();
        baseInfoDTO.setApplyPolicyNo(applyPolicyNo);
        contractDTO.setBaseInfoDTO(baseInfoDTO);
        applyWillDTO.setContractDTO(contractDTO);
        applyWillDTO.setApplyPolicyNo(applyPolicyNo);
        applyWillDTO.setCreatedBy("guanzhongxing");
        applyWillDTO.setCreatedDate(new Date());
        applyWillDTO.setDepartmentCode("20103");
        this.mongoTemplate.save(applyWillDTO);
        System.out.println("save success");
    }

    @Test
    public void insertApplyPolicyCardNoRelTest() {
        String applyPolicyNo = "333333";
        ApplyPolicyCardNoRel applyPolicyCardNoRel = new ApplyPolicyCardNoRel();
        applyPolicyCardNoRel.setApplyPolicyNo(applyPolicyNo);
        applyPolicyCardNoRel.setCardNo("123456");
        applyPolicyCardNoRel.setCardType("01");
        applyPolicyCardNoRel.setIsGroup("N");
        applyPolicyCardNoRel.setTelephone("1234567890");
        applyPolicyCardNoRel.setCreatedBy("guanzhongxing");
        applyPolicyCardNoRel.setFarmerName("zhangsan");
        applyPolicyCardNoRel.setStatus("1");
        this.mongoTemplate.save(applyPolicyCardNoRel);
    }

    @Test
    public void pagedQueryTest() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("applyPolicyCardNoRel")
                .localField("applyPolicyNo")
                .foreignField("applyPolicyNo")
                .as("applyWillList");
        Criteria criteria = new Criteria();
        criteria.and("cardNo").is("123456");
        criteria.and("cardType").is("01");
        criteria.and("isGroup").is("N");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria),
                lookupOperation
        );
    }
}

