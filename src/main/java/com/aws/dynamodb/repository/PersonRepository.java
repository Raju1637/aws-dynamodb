package com.aws.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.aws.dynamodb.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@RequiredArgsConstructor
@Repository
public class PersonRepository {

    private final DynamoDBMapper mapper;

    public Person save(Person person){
        mapper.save(person);
        return person;
    }

    public Person findByPersonId(String personId) {
        return mapper.load(Person.class, personId);
    }

    public String deletePerson(Person person) {
        mapper.delete(person);
        return "Person deleted with name: " + person.getName();
    }

    public Person updatePerson(Person person) {
        mapper.save(person, expression(person));
        return person;
    }

    private DynamoDBSaveExpression expression(Person person) {
        var expression = new DynamoDBSaveExpression();
        var map = new HashMap<String, ExpectedAttributeValue>();
        map.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));

        expression.setExpected(map);
        return expression;
    }

}
