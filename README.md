ReddGWT
=======
source for the reddgwt project.

#### Demo
http://reddgwt.appspot.com/


#### Description

ReddGWT was an experiment implementing Google Web Toolkit's [JavaScript Native Interface (JSNI)](http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJSNI.html), and [ Cross-site Client-Server Communication](http://www.gwtproject.org/doc/latest/tutorial/Xsite.html) features.


This project uses the [Reddit API](http://www.reddit.com/dev/api) to retrieve reddit posts using cross-site AJAX requests, and JSONP. The list of reddit posts are retrieved as JSON, converted into JavaScript objects using GWT's JSNI, and shown using custom widgets.

This allows the user to access Reddit using just Javascript, which establishes a platform for a browser addon for customizable browsing of reddit.
