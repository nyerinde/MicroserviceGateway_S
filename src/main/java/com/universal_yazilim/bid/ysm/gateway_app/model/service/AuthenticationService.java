package com.universal_yazilim.bid.ysm.gateway_app.model.service;

import com.universal_yazilim.bid.ysm.gateway_app.model.entity.User;
import com.universal_yazilim.bid.ysm.gateway_app.security.model.UserPrincipal;
import com.universal_yazilim.bid.ysm.gateway_app.utility.Util;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

//******4 -> generateJWT() metodunun ne yaptığını anlatmak üzere
//AbstractAuthenticationService'de ilgili unsurlar tanımlanır.
@Service
public class AuthenticationService extends  AbstractAuthenticationService
{
    ///******10


    @Override
    public String generateJWT(User user)
    {
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()); /// **** d 10.4

        try {

            Authentication authentication = authenticationManager.authenticate(authenticationToken); ///**** c 10.3

            //Bu nesneyi oluşturabilmek için, Authentication tipinde nesne gerekir.
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal(); // ***** b 10.2


            //token üretilirken , kimliği doğrulanmış kullanıcı kullanılır.
            //Yani param olarak kimliği doğrulanmış kullanıcı yollanır.
            return jwtProvider.generateToken(userPrincipal);//***** a -10.1
        }
        catch (AuthenticationException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }


    }
}
