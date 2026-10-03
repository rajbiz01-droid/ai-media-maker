# HTML → APK (Android app, फ़ोन पर ही)

Choose → Name → Create → Install. कंप्यूटर, Android Studio, Gradle या SDK नहीं चाहिए।

## आर्किटेक्चर
```
UI (MainActivity, Strings: English | हिंदी)
  → ProjectImporter     HTML file / ZIP / folder पढ़ना, index.html खोजना
  → ProjectValidator    खाली? पढ़ने लायक? जुड़ी files मौजूद?
  → AppIdentity         App name से package id अपने-आप
  → BuildEngine         interface (UI सिर्फ इसे जानता है)
       └ LocalPatchEngine   offline: ready template APK में नाम/icon/HTML बदलकर sign
         (बाद में CloudBuildEngine इसी interface पर लग सकता है)
  → OutputManager       Downloads में सेव, Install, Share, Open Location
```

## Local engine कैसे काम करता है
`template/` module (छोटा WebView app) build के समय APK बनकर `app/` के assets में रखा जाता है।
फ़ोन पर: binary manifest + resources.arsc में package/label बदलना, icon बदलना,
`assets/www/` में आपकी files जोड़ना, फिर apksig से sign (v1+v2)।

## Privacy / Security
- कोई network permission नहीं, कोई upload नहीं, कोई account नहीं। सब कुछ फ़ोन पर।
- बने हुए app में सिर्फ INTERNET permission है (ताकि online resources/links चल सकें)।
- Generated app की WebView: file access बंद, https virtual origin, JS + localStorage + IndexedDB चालू।

## इस app का APK बनाना (कंप्यूटर के बिना)
GitHub पर repository बनाएं → `.github/workflows/build.yml` बनाएं (build.yml का text) →
`apk-creator.zip` upload करें → Actions पूरा होने पर Releases से `HTML-to-APK.apk` download करें।
Min Android: 10 (API 29).
