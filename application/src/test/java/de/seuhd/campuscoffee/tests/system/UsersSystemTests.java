package de.seuhd.campuscoffee.tests.system;

import de.seuhd.campuscoffee.api.dtos.UserDto;
import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.tests.TestFixtures;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class UsersSystemTests extends AbstractSysTest {

    //TODO: Uncomment once user endpoint is implemented

    @Test
    void createUser() {
        User userToCreate = TestFixtures.getUserListForInsertion().getFirst();
        UserDto dto = userDtoMapper.fromDomain(userToCreate);
        UserDto returnedDto = given().contentType("application/json").body(dto).when().post("/api/users").then().statusCode(201).extract().as(UserDto.class);
        User createdUser = userDtoMapper.toDomain(returnedDto);
        assertEqualsIgnoringIdAndTimestamps(createdUser, userToCreate);
    }

    //TODO: Add at least two additional tests for user operations
    @Test
    void createAndGetUsersById(){
        User userToCreate = TestFixtures.getUserListForInsertion().getFirst();
        UserDto dto = userDtoMapper.fromDomain(userToCreate);
        UserDto createdDto = given().contentType("application/json").body(dto).when().post("/api/users").then().statusCode(201).extract().as(UserDto.class);
        User createdUser = userDtoMapper.toDomain(createdDto);
        UserDto fetchedDto=given().when().get("/api/users/" + createdUser.id()).then().statusCode(200).extract().as(UserDto.class);
        User fetchedUser = userDtoMapper.toDomain(fetchedDto);
        assertEqualsIgnoringIdAndTimestamps(fetchedUser, userToCreate);
    }
    @Test
    void createAndFilterUserByLoginName(){
        User userToCreate = TestFixtures.getUserListForInsertion().getFirst();
        UserDto dto = userDtoMapper.fromDomain(userToCreate);
        UserDto createdDto= given().contentType("application/json").body(dto).when().post("/api/users").then().statusCode(201).extract().as(UserDto.class);
        User createdUser = userDtoMapper.toDomain(createdDto);
        UserDto filteredDto = given().when().get("/api/users/filter?loginName=" + createdUser.loginName()).then().statusCode(200).extract().as(UserDto.class);
        User filteredUser = userDtoMapper.toDomain(filteredDto);
        assertEqualsIgnoringIdAndTimestamps(filteredUser, userToCreate);
    }
}