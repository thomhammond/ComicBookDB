import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.List;

public class ComicBookTableHelper {
    private AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().build();
    private DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);

    private String tableName = "ComicBook";

    private List<KeySchemaElement> keySchema = List.of(new KeySchemaElement("cbid", KeyType.HASH));

    private List<AttributeDefinition> attributeDefinitions = List.of(new AttributeDefinition().withAttributeName("cbid").withAttributeType("S"));

    private ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput().withReadCapacityUnits(10L).withWriteCapacityUnits(10L);

    public Table createTable() {
        System.out.println("Creating the ComicBook DynamoDB Table...");

        CreateTableRequest request = new CreateTableRequest()
                .withTableName(tableName)
                .withKeySchema(keySchema)
                .withAttributeDefinitions(attributeDefinitions)
                .withProvisionedThroughput(provisionedThroughput);
        try {
            Table table = dynamoDB.createTable(request);

            table.waitForActive();
            System.out.println("ComicBook Table successfully created!");
            System.out.println("Status: " + table.getDescription().getTableStatus());

            return table;
        } catch (InterruptedException e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());

            return null;
        }
    }

    public void deleteTable(Table table) {
        try {
            table.delete();
            table.waitForDelete();
        } catch (InterruptedException e) {
            System.err.println("Unable to delete table: ");
            System.err.println(e.getMessage());
        }
    }
}
