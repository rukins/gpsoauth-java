# Server endpoints

## Auth

## Receiving a master token
```http request
POST https://android.clients.google.com/auth
```

*with parameters:*

- `lang` - **en-US**
- `google_play_services_version` - **19629032**
- `sdk_version` - **28** *(it doesn't matter which version to specify)*
- `device_country` - **us**
- `Email` - *(can be empty)*
- `service` - **ac2dm**
- `get_accountid` - **1**
- `ACCESS_TOKEN` - **1**
- `callerPkg` - **com.google.android.gms** *(it doesn't matter which google service to specify)*
- `add_account` - **1**
- `Token` - **oauth2_4/** *(authentication token you received [here](https://accounts.google.com/EmbeddedSetup))*
- `callerSig` - **38918a453d07199354f8b19af05ec6562ced5788**

*Returns:*
```
Token=aas_et/***
Auth=
SID=
LSID=
services=
Email=
accountId=
GooglePlusUpdate=
firstName=
lastName=
capabilities.canHaveUsername=
capabilities.canHavePassword=
capabilities=
```

## Receiving an access token
```http request
POST https://android.clients.google.com/auth
```

*with parameters:*

- `accountType` - **HOSTED_OR_GOOGLE**
- `Email` - *(can be empty)*
- `has_permission` - **1**
- `EncryptedPasswd` - **aas_et/** *(master token)*
- `service` - **oauth2:https://www.googleapis.com/auth/memento https://www.googleapis.com/auth/reminders** *(google service you want to get access)*
- `source` - **android**
- `androidId` - *can be empty*
- `app` - **com.google.android.keep** *(app you want to get access)*
- `client_sig` - **38918a453d07199354f8b19af05ec6562ced5788**
- `device_country` - **us**
- `operatorCountry` - **us**
- `lang` - **en**
- `sdk_version` - **28** *(it doesn't matter which version to specify)*

*Returns:*
```
issueAdvice=
Expiry=
ExpiresInDurationSec=
storeConsentRemotely=
isTokenSnowballed=
grantedScopes=
Auth=ya29.***
```
