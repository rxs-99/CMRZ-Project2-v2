package com.revature.utility;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Person;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
	private static final String SECRET = "nibR19FuoJuYst0iDt5BEVqJc6nZplPhEz3zsfin+t+60Delio/pMW8f38ZRRHt3C5UmhxLqRJ1fDeaUmof47g0YJ/sZCtlqX+rAbQ6MYrp5KvLdqIgBE9O4Eu5/FSmm3kYZE0kIzkZNehAAt9bDbfdNI8ZUVnPqgiPDjS4brqA=";
	
	public static String getJWTToken(String username, Person p) {
		String token = Jwts.builder().setId(Integer.toString(p.getId())).setSubject(username)
				.claim("role", p.getPosition().getName()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1800000))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

		return token;
	}

	public static boolean checkJWTToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(HEADER);
        if(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)){
            return false;
        }
        return true;
	}

	public static Claims validateToken(HttpServletRequest request){
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}
	
	// // note needed ... only for reference ... delete before final push
	// private void setUpSpringAuthentication(Claims claims){
    //     String role = (String)claims.get("role");
        
    //     UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), role);


    //     System.out.println("setUpSpringAuthentication");

    //     SecurityContextHolder.getContext().setAuthentication(auth);
	// }
	
	// protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    //         throws ServletException, IOException {
    //     try {
    //         if(checkJWTToken(request)){
    //             Claims claims = validateToken(request);
    //             if(claims.get("role") != null){
    //                 setUpSpringAuthentication(claims);
    //             } else {
    //                 SecurityContextHolder.clearContext();
    //             }
    //         } else {
    //             SecurityContextHolder.clearContext();
    //         }
    //         filterChain.doFilter(request, response);
    //     } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
    //         response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    //         ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    //         return;
    //     }

    // }
	
}
