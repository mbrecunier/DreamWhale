# DreamWhale

##### Dream Journal Android App, 5/10/2016

#### By Anna Becker, Michelle Brecunier, Charles Carter, Chris Young

## Description

This Android application is a journal for users to track their dreams with the option of sharing them with the DreamWhale community.

##### Current Features
* Account creation and authentication with your email address through Firebase
* Easily navigate through app with menu bar
* Add a date, color, and description to your dream entry
* View your personal dream journal by date
* Option to anonymously share your dream with the community
* View the community dream journal to get an insight into other people's dreams

##### Features in Progress
* View whale word clouds containing popular words from your personal journal and the community journal
* View dream color trends from your personal journal and the community journal
* Easily share your dreams on social media
* Available in the Google Play Store

## Setup/Installation Requirements
You will need the following programs installed on your computer.
* Android Studio
* Java JDK 8+
* Android SDK

### To Run Application
* In a terminal window, navigate to ~/AndroidStudioProjects
* Run `git clone https://github.com/mbrecunier/DreamWhale.git`
* Navigate to ~/AndroidStudioProjects/DreamWhale
* Run on either an emulator or an Android OS Device connected to a computer

##### To set up an emulator
* Select Run > Run 'app'
* Click 'Create New Emulator'
* Select the device you would like to emulate (Recommended: Nexus 6)
* Select the API level you would like to run - click 'Download' if not available (Recommended: Marshmallow - ABI: x86)
* Select configuration settings for emulator
* Click 'Finish' and allow Emulator to run

##### To Run on an Android OS Device
* Connect the device to the computer through its USB port
* Make sure USB debugging is enabled (this may pop up in a window when you connect the device or it may need to be checked in the phone's settings)
* Select Run > Run 'app'
* Select the device (If it does not show, USB debugging is probably not enabled)
* Click 'OK'

## Technologies Used

Java, Android Studio, Gradle, Firebase, [ColorPicker](https://github.com/LarsWerkman/HoloColorPicker/) by [LarsWerkman](https://github.com/LarsWerkman)

### Legal

Copyright (c) 2016 Anna Becker, Michelle Brecunier, Charles Carter, Chris Young

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.