package com.universal_yazilim.bid.ysm.gateway_app.model.service;

import com.universal_yazilim.bid.ysm.gateway_app.model.entity.User;
import com.universal_yazilim.bid.ysm.gateway_app.security.jwt.JWTProvidable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

//*****3 -> AuthenticationService tanımlanır
public abstract  class AbstractAuthenticationService
{
    //******8
    @Autowired
    protected JWTProvidable jwtProvider;

    //******5 -> AuthenticationManager nesnesini döndüren @Bean tanımlanır
    //(bkz. dependency injection)
    @Autowired
    protected AuthenticationManager authenticationManager;


    /**
     *
     * @param user
    sign-in işleminde bilgileri girilen kullanıcı
     @return
     kimliği doğrulanmış kullanıcı için oluşturulan JWT
     eğer kimlik doğrulama hatası meydana gelirse, null
     */
    public abstract String generateJWT(User user);

}
