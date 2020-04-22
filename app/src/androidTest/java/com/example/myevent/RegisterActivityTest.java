    package com.example.myevent;

    import androidx.test.espresso.ViewAction;
    import androidx.test.rule.ActivityTestRule;

    import org.junit.Rule;
    import org.junit.Test;

    import static androidx.test.espresso.Espresso.onView;
    import static androidx.test.espresso.action.ViewActions.click;
    import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
    import static androidx.test.espresso.action.ViewActions.replaceText;
    import static androidx.test.espresso.action.ViewActions.typeText;
    import static androidx.test.espresso.matcher.ViewMatchers.withId;

    public class RegisterActivityTest {

        @Rule
        public ActivityTestRule<Register> nActivity = new ActivityTestRule<>(Register.class);

        private String email ="syfanur@gmail.com";
        private String name ="nur lathifah";
        private String password ="1234";
        private String c_password = "1234";
        private String username = "syfaaa";

        @Test
        public void emailInputEditable(){
            onView(withId(R.id.editText6)).perform(typeText(email), closeSoftKeyboard());
        }

        @Test
        public void nameInputEditable(){
            onView(withId(R.id.editText)).perform(typeText(name), closeSoftKeyboard());
        }

        @Test
        public void passwordInputEditable(){
            onView(withId(R.id.editText7)).perform(typeText(password), closeSoftKeyboard());
        }

        @Test
        public void cpasswordInputEditable(){
            onView(withId(R.id.editText8)).perform(typeText(c_password), closeSoftKeyboard());
        }

        @Test
        public void usernameInputEditable(){
            onView(withId(R.id.editText5)).perform(typeText(username), closeSoftKeyboard());
        }



    }
