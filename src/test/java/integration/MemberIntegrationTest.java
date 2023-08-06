package integration;

import static integration.helper.CommonRestAssuredUtils.post;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shopping.member.dto.LoginRequest;
import shopping.member.dto.LoginResponse;

class MemberIntegrationTest extends IntegrationTest {

    @Test
    @DisplayName("일치하는 emaill과 password로 로그인을 성공한다")
    void loginSuccess() {
        // given from test_data.sql

        ExtractableResponse<Response> response =
            post("/login", new LoginRequest("hello@woowa.com", "hello1"));

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.body().as(LoginResponse.class))
            .extracting("accessToken")
            .isNotNull();
    }
}
