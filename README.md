# Unofficial Java client library for Google Play Services OAuth
Simple library that can be used to get access some non-public Google APIs as an Android Device.

## Table of content
- [General info](#general-info)
  - [Receiving an authentication token](#receiving-an-authentication-token)
  - [Types of tokens](#types-of-tokens)
- [Download](#download)
- [Simple example](#simple-example)
- [Report Issues](#report-issues)
- [Contributing](#contributing)
- [License](#license)

## General info

### Receiving an authentication token
To get a master token, firstly you need to receive an authentication token. 
In a nutshell, you just need to obtain the value of the `oauth_token` cookie after logging in to your Google account via https://accounts.google.com/EmbeddedSetup

Detailed instructions are provided below (I use Google Chrome, but I think the actions are similar in other browsers):

#### First way
1. Go [here](https://accounts.google.com/EmbeddedSetup), log in to your Google account and agree to the terms \
\
![step1](./doc/images/step1-to-receive-auth-token.png)

2. Find the `lock` \
\
![step1](./doc/images/way1-step2-to-receive-auth-token.png)

3. Go to the `Cookies` section \
\
![step1](./doc/images/way1-step3-to-receive-auth-token.png)

4. Expand the `accounts.google.com` dropdown menu \
\
![step1](./doc/images/way1-step4-to-receive-auth-token.png)

5. Find the `oauth_token` inside the `Cookies` menu and copy the token from the `Content` field \
\
![step1](./doc/images/way1-step5-to-receive-auth-token.png)


#### Second way

1. Go [here](https://accounts.google.com/EmbeddedSetup), log in to your Google account and agree to the terms \
\
![step1](./doc/images/step1-to-receive-auth-token.png)

2. Open `Developer tools`

3. Go to the `Application` section and look for `https://accounts.google.com` inside `Cookies` dropdown menu \
\
![step1](./doc/images/way2-step2-to-receive-auth-token.png)

4. Expand the `accounts.google.com` dropdown menu, find the `oauth_token` and copy the Cookie value  \
\
![step1](./doc/images/way2-step4-to-receive-auth-token.png)

### Types of tokens

- Authentication token (starts with `oauth2_4/`) *expires quickly, can be used only once*
- Master token (starts with `aas_et/`) *never expires*
- Access token (starts with `ya29.`) *expires in 1 hour*

## Download
### *Available [here](https://mvnrepository.com/artifact/io.github.rukins/gpsoauth)*
#### Maven
```xml
<dependency>
    <groupId>io.github.rukins</groupId>
    <artifactId>gpsoauth</artifactId>
</dependency>
```
#### Gradle
```groovy
implementation group: 'io.github.rukins', name: 'gpsoauth'
```
#### Gradle (Kotlin)
```kotlin
implementation("io.github.rukins:gpsoauth")
```

## Simple example

```java
import io.github.rukins.gpsoauth.Auth;
import io.github.rukins.gpsoauth.exception.AuthError;
import io.github.rukins.gpsoauth.model.MasterToken;
import io.github.rukins.gpsoauth.model.MasterTokenRequestParams;

public class Main {
  public static void main(String[] args) {
    Auth auth = new Auth();

    MasterTokenRequestParams masterTokenRequestParams = MasterTokenRequestParams
            .withDefaultValues()
            .token("oauth2_4/***")
            .build();

    MasterToken masterToken;
    try {
      masterToken = auth.getMasterToken(masterTokenRequestParams);
    } catch (AuthError e) {
      System.out.println(e.getErrorObject());

      return;
    }

    AccessTokenRequestParams accessTokenRequestParams = AccessTokenRequestParams
            .withDefaultValues()
            .masterToken(masterToken.getMasterToken())
            .app("com.google.android.keep")
            .scopes("oauth2:https://www.googleapis.com/auth/memento https://www.googleapis.com/auth/reminders")
            .build();

    AccessToken accessToken;
    try {
      accessToken = auth.getAccessToken(accessTokenRequestParams);
    } catch (AuthError e) {
      System.out.println(e.getErrorObject());

      return;
    }

    System.out.println(masterToken.getMasterToken());
    System.out.println(accessToken.getAccessToken());
  }
}
```

#### And for example, request notes with an access token:
```
curl -i -X GET -H "Authorization: OAuth ya29.***" "https://www.googleapis.com/notes/v1/changes"
```

## Report Issues
In the [Issues](https://github.com/rukins/gpsoauth/issues) section you can suggest any improvements and report any bugs you find

## Contributing
This is an open-source project and all contributions are highly welcomed

## License

Released under [MIT License](LICENSE)