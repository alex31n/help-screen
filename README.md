# help-screen
Best way to create user guide screen in any android app
![Help Screen](https://raw.githubusercontent.com/alex31n/help-screen/master/assets/banner_01.jpg)
 [ ![Download](https://api.bintray.com/packages/alex31n/help-screen/help-screen/images/download.svg) ](https://bintray.com/alex31n/help-screen/help-screen/_latestVersion) ![GitHub version](https://d25lcipzij17d.cloudfront.net/badge.svg?id=gh&type=6&v=1.0)


### Gradle 

```
dependencies {
    implementation 'com.ornach.helpscreen:help-screen:1.0'
}
```
&nbsp;
### Use
```
HelpScreen helpScreen = new HelpScreen.Builder(this)
          .setFocusCx(x)
          .setFocusCy(y)
          .setFocusRadius(200)
          .setBorderColor(Color.parseColor("#99FFFFFF"))
          .setBorderSize(50)
          .setTitle(new HelpText("Simple Title"))
          .setMessage(new HelpText("This is a simple message. You can change this later. \nTap anywhere to dismiss"))
          .build();
helpScreen.show();

// helpscreen listener
helpScreen.setOnHelpScreenListener(new OnHelpScreenListener() {
          @Override
          public void onShow() {
              // todo something
          }

          @Override
          public void onDismiss() {
              // todo something
          }
      });
        
```
&nbsp;
#### Advance
```
TextStyle titleStyle = new TextStyle.Builder()
          .setTextColor(Color.YELLOW)
          .setFontStyle(TextStyle.FontStyle.BOLD)
          .setTextSize(22)
          .build();
HelpText title = new HelpText("Simple Title", titleStyle);

TextStyle messageStyle = new TextStyle.Builder()
          .setWidth(800)
          .setMargin(10, 50, 10, 0)
          .build();
HelpText message = new HelpText("This is a simple message.", messageStyle);

HelpScreen helpScreen = new HelpScreen.Builder(this)
          .setFocusCx(x)
          .setFocusCy(y)
          .setFocusRadius(150)
          .setBorderSize(20)
          .setBorderColor(Color.GRAY)
          .setBackgroundColor(Color.GRAY)
          .setTitle(title)
          .setMessage(message)
          .addShader(new Shader(Color.GRAY, 700))
          .addShader(new Shader(Color.GRAY, 400))
          .build();
helpScreen.show();
```
&nbsp;
#### CustomView
```
View view = LayoutInflater.from(this).inflate(R.layout.custom_layout, null);
HelpScreen helpScreen = new HelpScreen.Builder(this)
          .setFocusCx(x)
          .setFocusCy(y)
          .setCustomView(view)
          .setFocusRadius(150)
          .setBorderColor(Color.parseColor("#DDFFFFFF"))
          .setBorderSize(30)
          .build();
helpScreen.show();
```

&nbsp;
## License
    Copyright 2019 Alex
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and limitations under the License.
    
