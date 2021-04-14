# noti

* check the manifest file n add 

       <uses-permission android:name="android.permission.VIBRATE"/>
       
* and 
       
        android:name=".NotificationChannel" respectively
      
      

* create NotificationChannel.java word to word

* this is the code for displaying a notification :
    
                Intent activityIntent = new Intent(MainActivity.this, TestActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                                              0,activityIntent, 0);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, NotificationChannel.CHANNEL_ID)
                        //set icon
                        .setSmallIcon(R.drawable.ic_noti_icon)
                        //set title
                        .setContentTitle("noti")
                        //set the stuff that appears appears below
                        .setContentText("this is a test noti")
                        //set priority level
                        .setSound(uri)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setContentIntent(contentIntent)
                        .setVibrate(vibrate)
                        .build();

                notificationManager.notify(1,notification);
            }
        });
        
* TestActivity.class is just a palceholder if you want to open a activity when notification is clicked

* if you dont want the notification to do nothing then you can remove :
                
                Intent activityIntent = new Intent(MainActivity.this, TestActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                        0,activityIntent, 0);
                        
   and
         
         .setContentIntent(contentIntent) from notification
