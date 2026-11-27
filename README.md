# Welcome App — تطبيق الترحيب بالمستخدم
مقرر: برمجة تطبيقات Android

## طريقة التشغيل
1. افتح Android Studio ← File ▸ Open ← اختر مجلد WelcomeApp.
2. انتظر انتهاء Gradle Sync (يحتاج اتصالًا بالإنترنت أول مرة).
3. اختر محاكيًا أو هاتفًا ثم اضغط Run ▶.

## عناصر الواجهة (IDs)
| العنصر | ID |
|---|---|
| TextView (عبارة أولية) | tvGreeting |
| EditText (الاسم) | etName |
| Button (عرض الترحيب) | btnShow |
| TextView (الرسالة النهائية) | tvResult |

## الملفات الرئيسية
- app/src/main/res/layout/activity_main.xml — تصميم الواجهة (ConstraintLayout)
- app/src/main/java/com/example/welcomeapp/MainActivity.kt — الكود (Kotlin)
