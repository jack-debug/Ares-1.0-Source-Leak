package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.tokens.Token;

public interface Scanner
{
    boolean checkToken(Token.ID... p0);
    
    Token peekToken();
    
    Token getToken();
}
