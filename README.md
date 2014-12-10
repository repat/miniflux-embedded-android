Miniflux embedded
======
**Miniflux embedded** is an Android app for the minimalist RSS Reader [Miniflux](http://miniflux.net). It's basically an embedded WebView that saves your Miniflux URL and [cookies](https://en.wikipedia.org/wiki/Magic_cookie). Since Miniflux is [responsive](https://en.wikipedia.org/wiki/Responsive_web_design) there is really no need for a real client, except for offline reading. So this app will only save you the trouble of logging in and/or using your browser.

#### Usage
[At the very first start and only then](https://www.youtube.com/watch?v=A4I9DMSvJxg) it will ask you for your Miniflux URL. If you mistyped, you can un- and reinstall the app or press *Clear data* under *Settings/Apps*.
It will then prompt you for your credentials. These are save by the Android internal [CookieSyncManager](https://developer.android.com/reference/android/webkit/CookieSyncManager.html). You can now use the app just like your webreader.

**I would strongly suggest a SSL secured(https://) connection!**

Developers: Since API 21 (Android 5.0), the `CookieSyncManager` is deprecated. An updated version using `CookieManager.flush()` will be provided in time. Also, with `webSettings.setJavaScriptEnabled(true)` the app is theoretically vulnerable to XSS.

#### Screenshot
![Screenshot](http://repat.de/Bilder/screenies/miniflux-embedded-android.png "Screenshot")

#### App Stores
[![Get it on Google Play](https://raw.github.com/repat/README-template/master/googleplay.png)](https://play.google.com/store/apps/details?id=de.repat.embeddedminiflux)

## Tests
#### Works on
* Motorola Moto G

#### Does not work on
*

## Contributors
### Artwork
The button is a black/white version of  [Custom color round square button](https://openclipart.org/detail/164215/custom-color-round-square-button-by-theboxmeister) by [theboxmeister](https://openclipart.org/user-detail/theboxmeister) from [openclipart.org](https://openclipart.org).

## Permissions
* INTERNET, for obvious reasons

## License 
* see [LICENSE](https://github.com/username/appname/blob/master/LICENSE.md) file

## Version 
* Version 1.0

## Contact
#### Developer
* Homepage: [http://repat.de](http://repat.de)
* e-mail: repat@repat.de
* Twitter: [@repat123](https://twitter.com/twitterhandle "repat123 on twitter")

[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=repat&url=https://github.com/repat/minifluxembedded&title=minifluxembedded&language=&tags=github&category=software) 

