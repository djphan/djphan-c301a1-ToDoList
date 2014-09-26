djphan_301a1
=============

CMPUT 301 - A1 - To Do List Application (written in Java)

An application to create and store a list of items. You can check
the items off after completion, email items, and keep track
of completed and uncompleted items.

Notes
=====
1. The selection feature in the E-Mail function does not work.
The only option to e-mail currently only sends the complete ToDo List
and Archive List. Bug involved in referencing multiple objects in ListView. Possible solution
in E-Mail Adapter or the E-Mail Activity files requires an OnClick multiple 
items reference.

Backend implementation of emailSelectArray developed for this function 
but could not sort out the bugs.

2. Data Serialization back-end implemented but not active. Current bug
in data streams from OnCreate to OnStart where save file overwrites
display ArrayLists. Problem in the way the display is generated
or sorting out data references. Sections commented out in 
Activity Java, back-end implementation available for viewing.


Instructions
============
NOTE
====
Check to see if the Action Bar has an overflow icon. If the icon is not there you need to select the menu button
to switch between the activities. The menu button on the right in the emulator is the hard wired menu button
for the phone version. This acts as the overflow button in the Action Bar and will navigate activities sucessfully.
====

Navigating between views require you to move from the Action bar in the MainMenu and
the back button in the Android menu. 

1. Selecting

2. Adding
	In the main ToDoList view you can add items to the list by typing into
	the text field and pressing the add icon. This will update the
	ToDoList

3. Archiving
	In both the main ToDoList view and the Archive view you must click the row
	to archive or unarchive the ToDoList Item. A prompt will popup to verify this change.
	
	In the ToDoList main view this will move our item to the archive.
	The archive can be accessed with the first icon on the action bar.
		
	The archive uses the same methods of the onClick method to unarchive items
	and you can select or unselect the check box per item.
	
	As well the archive and the main TodDoList uses the same Delete function

4. Delete
	In both the main ToDoList view and the Archive view you must longclick the row
	to delete the ToDoList Item. A prompt will pop up to verify this change.
	This will delete the item from the system.

5. Email
	At the moment select email does not work. However using the view provided you can
	email either the full ToDo list (under email) or the full Archive (under Email Archive).
	
	This should launch a popup that references your email app.


6. Statistics
	In the action bar on the top right on the in menu you may select the information icon.
	This loads up the statistics page where you can watch the app keep track of the internal
	number of ToDoList Items
	

To Do Fixes/Considerations
==========================
1. Consider adding a self.emailcheck field in ListItem to implement E-Mail Selection using
check boxes. Create LayoutXML and populate listview with current method.

2. Background color fill to improve highlighting/selection actions.

License
=======

Copyright 2014 Daniel Phan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.

You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

You can contact the author at djphan [at] ualberta [dot] ca.


Resources
===========

1. Vogella Tutorials were used in learning and adapting 
ListView (http://www.vogella.com/tutorials/AndroidListView/article.html) and 
Action Bars (http://www.vogella.com/tutorials/AndroidActionBar/article.html).
Tutorials were used specifically for the ViewHolder static class and View
getView override when generating the ListView

The licensing information for adapted code falls under EPL 1.0 License 
(obtained at https://www.eclipse.org/legal/epl-v10.html). 

This web site may contain other proprietary notices and copyright 
information, the terms of which must be observed and followed. 

If not otherwise stated, reuse of the example source code must meet 
the conditions of the Eclipse Public License 1.0 while all other content 
falls under the Creative Commons Attribution-NonCommercial-ShareAlike 3.0 
Germany license. 

2. For the Email Functions, code snippet taken from 
fiXedd (http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application)
was used in the Email Handler

Stack OverFlow Content on the Network (the “Creative Commons Data Dump”). The Creative Commons Data Dump 
is licensed under the Creative Commons Attribution Share Alike license. By downloading The Creative
Commons Data Dump, You agree to be bound by the terms of that license.

Any other downloading, copying, or storing any Content for other than personal, noncommercial use is expressly prohibited without 
prior written permission from Stack Exchange, or from the copyright holder identified in such Content's copyright notice. In 
the event You download software from the Network, the software, including any files, images incorporated in or generated by the software,
and the data accompanying the software (collectively, the “Software”) is licensed to You by Stack Exchange or third party licensors for Your 
personal, noncommercial use, and no title to the Software shall be transferred to You. Stack Exchange or third party licensors retain full and 
complete title to the Software and all intellectual property rights therein.

In the event that You post or otherwise use Subscriber Content outside of the Network or Services, with the exception of content entirely created by You,
You agree that You will follow the attribution rules of the Creative Commons Attribution Share Alike license as follows:

You will ensure that any such use of Subscriber Content visually displays or otherwise indicates the source of the Subscriber Content as coming from 
the Stack Exchange Network. This requirement is satisfied with a discreet text blurb, or some other unobtrusive but clear visual indication.

You will ensure that any such Internet use of Subscriber Content includes a hyperlink directly to the original question 
on the source site on the Network (e.g., http://stackoverflow.com/questions/12345)

You will ensure that any such use of Subscriber Content visually display or otherwise 
clearly indicate the author names for every question and answer so used.

You will ensure that any such Internet use of Subscriber Content Hyperlink each author name
directly back to his or her user profile page on the source site on the Network (e.g., http://stackoverflow.com/users/12345/username),
directly to the Stack Exchange domain, in standard HTML (i.e. not through a Tinyurl or other such indirect hyperlink, form of obfuscation or redirection), 
without any “nofollow” command or any other such means of avoiding detection by search engines, and visible even with JavaScript disabled.

3. Android Developer Website (http://developer.android.com/index.html) was used as a resource for Android specific framework. 

We are pleased to license the Android documentation and sample code on this web site under terms that encourage you to take, modify, 
reuse, re-purpose, and remix the content as you see fit. The documentation content on this web site is made available to you as part of 
the Android Open Source Project. This documentation, including any code shown in it, is licensed under the Apache 2.0 license. 

All other content on this site, except the license documents themselves and as otherwise noted, is licensed under the Creative Commons 
Attribution 2.5 license. For more information about licenses provided for the content of this web site and the restrictions for re-use, 
read the complete Content License.

Your use of this site is subject to Google's Privacy Policy & Terms of Service.

4. LonelyTwitter Lab 2/3 were used as a template for the DataManager, iDataManager and Statistics Activity Page.
   This material was forked from dfserrano (https://github.com/dfserrano/LonelyTwitterGson). This material is assumed
   to be in in the public domain for the course to use.


