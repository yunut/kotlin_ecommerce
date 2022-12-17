package com.jys.kotlin_practice.account

import com.jys.kotlin_practice.config.subject
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/account"], produces = [MediaType.APPLICATION_JSON_VALUE])
class AccountController(
    private val accountService: AccountService
) {
    /**
     * 회원가입
     * @param signupRequest 회원가입 요청 필드 데이터
     */
    @PostMapping(value = ["/signup"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(value = HttpStatus.CREATED)
    fun signup(@Valid @RequestBody signupRequest: SignupRequest) {
        accountService.signup(signupRequest)
    }

    /**
     * 프로필 조회
     * @param authentication 인증 정보
     */
    @GetMapping(value = ["/profile"])
    fun getProfile(authentication: BearerTokenAuthentication) {
        println(authentication.subject)
    }
}