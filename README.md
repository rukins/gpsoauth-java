# Unofficial Java client library for Google Play Services OAuth
Simple library that can be used to get access some non-public Google APIs as an Android Device.

## Table of content
- [General info](#general-info)
  - [Receiving an authentication token](#receiving-an-authentication-token)
  - [Types of tokens](#types-of-tokens)
- [Download](#download)
- [Simple example](#simple-example)
- [Technologies and Libraries](#technologies-and-libraries)
- [Similar libraries](#similar-libraries)
- [Report Issues](#report-issues)
- [License](#license)

## General info

### Receiving an authentication token
To get a master token, firstly you need to receive an authentication token.

Follow these steps to take it:
1. Go [here](https://accounts.google.com/EmbeddedSetup), log in with a Google account and agree to the terms \
\
![step1](./doc/images/step1-to-receive-auth-token.png)

2. Find the `lock` \
\
![step1](./doc/images/step2-to-receive-auth-token.png)

3. Go to the `Cookie` section \
\
![step1](./doc/images/step3-to-receive-auth-token.png)

4. Expand the `accounts.google.com` dropdown menu \
\
![step1](./doc/images/step4-to-receive-auth-token.png)

5. Find the `oauth_token` inside the `Cookie` menu and copy a token from the `Content` field \
\
![step1](./doc/images/step5-to-receive-auth-token.png)

### Types of tokens

- Authentication token (starts with `oauth2_4/`) *expires quickly, can be used only once*
- Master token (starts with `aas_et/`) *never expires*
- Access token (starts with `ya29.`) *expires in 1 hour*

## Simple example
```java
package example;

import io.github.rukins.Auth;
import io.github.rukins.model.AccessToken;
import io.github.rukins.model.AccessTokenRequestParams;
import io.github.rukins.model.MasterToken;
import io.github.rukins.model.MasterTokenRequestParams;

public class Main {
    public static void main(String[] args) {
        Auth auth = new Auth();

        MasterTokenRequestParams masterTokenRequestParams = MasterTokenRequestParams
                .withDefaultValues()
                .token("oauth2_4/***")
                .build();

        MasterToken masterToken = auth.getMasterToken(masterTokenRequestParams);

        AccessTokenRequestParams accessTokenRequestParams = AccessTokenRequestParams
                .withDefaultValues()
                .masterToken(masterToken.getMasterToken())
                .app("com.google.android.keep")
                .scopes("oauth2:https://www.googleapis.com/auth/memento https://www.googleapis.com/auth/reminders")
                .build();

        AccessToken accessToken = auth.getAccessToken(accessTokenRequestParams);
        
        System.out.println(masterToken.getMasterToken());
        System.out.println(accessToken.getAccessToken());
    }
}
```

#### And for example, request notes with an access token:
```
curl -i -X GET -H "Authorization: OAuth ya29.***" "https://www.googleapis.com/notes/v1/changes"
```

## Download


## Technologies and Libraries
- Java version: 17
- Gson version: 2.10.1

## Similar libraries
- Python: https://github.com/simon-weber/gpsoauth
- Node.js: https://github.com/GoneToneStudio/node-google-play-api
- C#: https://github.com/vemacs/GPSOAuthSharp
- Ruby: https://github.com/bryanmytko/gpsoauth
- Java: https://github.com/svarzee/gpsoauth-java
- C++: https://github.com/dvirtz/gpsoauth-cpp and https://github.com/Iciclelz/gpsoauthclient

## Report Issues
In the [Issues](https://github.com/rukins/gpsoauth/issues) section you can suggest any improvements and report any bugs you find

## Contributing
This is an open-source project and all contributions are highly welcomed

## License

Released under [MIT License](LICENSE)