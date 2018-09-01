




NB: this repository is for testing only.. looking for this project, then use the author's repository at
https://github.com/chemerisuk/cordova-plugin-firebase-dynamiclinks





---------------------
---------------------
---------------------
---------------------
---------------------
---------------------
---------------------


# cordova-plugin-firebase-dynamiclinks<br>[![NPM version][npm-version]][npm-url] [![NPM downloads][npm-downloads]][npm-url]
> Cordova plugin for [Firebase Dynamic Links](https://firebase.google.com/docs/dynamic-links/)
 
## Installation

    cordova plugin add ... --save --variable APP_DOMAIN="example.com" --variable PAGE_LINK_DOMAIN="example.page.link"

Use variable `APP_DOMAIN` specify web URL where your app will start an activity to handle the link.

Use variable `PAGE_LINK_DOMAIN` specify your `*.page.link` domain.

Use variable `FIREBASE_DYNAMIC_LINKS_VERSION` to override dependency version on Android.

## Supported Platforms

- iOS
- Android


## Methods

### onDynamicLink(_callback_)
Registers callback that is triggered on each dynamic link click.
```js
cordova.plugins.firebase.dynamiclinks.onDynamicLink(function(data) {
    console.log("Dynamic link click with data: ", data);
});
```

Software taken from chemerisuk/cordova-plugin-firebase-dynamiclinks
