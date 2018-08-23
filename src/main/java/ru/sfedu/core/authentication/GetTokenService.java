package ru.sfedu.core.authentication;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.core.model.Users;
import ru.sfedu.core.util.Constans;

/**
 *
 * @author sergei
 */
public class GetTokenService {

    private static final Logger logger = LogManager.getLogger("GetTokenService.class");

    /**
     *
     * @param login
     * @param password
     * @return
     */
    public Users loginUser(String login, String password) {
        Users model;
        model = new Authorization().login(login, password);
        if (model == null ? false : model.getEmail().equals(login)) {
            String jwtStr = Jwts.builder()
                    .setId(String.valueOf(model.getId()))
                    .setSubject(model.getEmail())
                    .claim("custom", "myCustom")
                    .signWith(
                            SignatureAlgorithm.HS256,
                            TextCodec.BASE64.decode(Constans.KEY)
                    )
                    .compact();
            model.setToken(jwtStr);
            return model;
        }
        return null;
    }

    /**
     *
     * @param jwtStr
     * @return
     */
    public String loginChekw(String jwtStr) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(
                            TextCodec.BASE64.decode(Constans.KEY)
                    )
                    .parseClaimsJws(jwtStr);
            return jws.getBody().getId();
        } catch (MissingClaimException | IncorrectClaimException e) {
            logger.info((Supplier<String>) e);
        } finally {
        }
        return null;
    }
}