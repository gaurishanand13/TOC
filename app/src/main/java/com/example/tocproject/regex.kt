package com.example.tocproject
import java.util.regex.Matcher
import java.util.regex.Pattern

object regexFunctions {

    /**
     * Accepts data in format "dd/mm/yyyy"
     */
    fun isValidDate(d: String?): Boolean {
        val regex = ("^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$")
        val pattern: Pattern = Pattern.compile(regex)
        val matcher: Matcher = pattern.matcher(d as CharSequence?)
        return matcher.matches()
    }


    /**
     * Example - <br/>  is a valid HTML Tag but br/> is not a valid HTML tag
     * "<input value = '>'>" is also a valid HTML TAG
     */
     fun isValidHTMLTag(str: String?): Boolean {
        val regex = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>"

        // Compile the ReGex
        val p = Pattern.compile(regex)

        // If the string is empty
        // return false
        if (str == null) {
            return false
        }
        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        val m = p.matcher(str)

        // Return if the string
        // matched the ReGex
        return m.matches()
    }


    /**
     * "https://www.geeksforgeeks.org" is valid URL whereas
     * "htts://www.geeksforgeeks.org" ,"https//www.geeksforgeeks.org",etc are not
     */
    fun isValidURL(url: String?): Boolean {
        // Regex to check valid URL
        val regex = ("((http|https)://)(www.)?" + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]" + "{2,6}\\b([-a-zA-Z0-9@:%" + "._\\+~#?&//=]*)")

        // Compile the ReGex
        val p = Pattern.compile(regex)

        // If the string is empty
        // return false
        if (url == null) {
            return false
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        val m = p.matcher(url)

        // Return if the string
        // matched the ReGex
        return m.matches()
    }


    /**
     * The valid Aadhar number must satisfy the following conditions:
     * It should have 12 digits.
     * It should not starts with 0 and 1.
     * It should not contains any alphabet and special characters.
     * It should have white space after every 4 digits.
     *
     * E.g - "3675 9834 6012" is a valid Aadhar Number whereas "3675 9834 6012 8” is not as it contains 13 digits.
     */
    fun isValidAadharNumber(str: String?): Boolean {
        val regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$"

        // Compile the ReGex
        val p = Pattern.compile(regex)

        // If the string is empty
        // return false
        if (str == null) {
            return false
        }

        // Pattern class contains matcher() method
        // to find matching between given string
        // and regular expression.
        val m = p.matcher(str)

        // Return if the string
        // matched the ReGex
        return m.matches()
    }


    /**
     * Valid Indian driving license number must satisfy these -
     * 1) It should be 16 characters long (including space or hyphen (-)).
     * 2) The driving license number can be entered in any of the following format - "HR-0619850034761" OR "HR06 19850034761"
     * 3) The first two characters should be upper case alphabets that represent the state code.
     * 4) The next two characters should be digits that represent the RTO code.
     * 5) The next four characters should be digits that represent the license issued year.
     * 6) The next seven characters should be any digits from 0-9.
     */
    fun isValidLicenseNo(str: String?): Boolean {
        val regex = ("^(([A-Z]{2}[0-9]{2})"
                + "( )|([A-Z]{2}-[0-9]"
                + "{2}))((19|20)[0-9]"
                + "[0-9])[0-9]{7}$")

        val p = Pattern.compile(regex)
        if (str == null) {
            return false
        }
        val m = p.matcher(str)
        return m.matches()
    }



    /**
     * Valid CVV Number is this -
     * 1) It should have 3 or 4 digit.
     * 2) It should have digit between 0-9.
     * 3) It should not have any alphabets and special characters.
     */
     fun isValidCVVNumber(str: String?): Boolean {

        val regex = "^[0-9]{3,4}$"
        /**
         * 1) ^ represents the starting of the string.
         * 2) [0-9] represents the digit between 0-9.
         * 3) {3, 4} represents the string have 3 or 4 digit.
         * 4) $ represents the ending of the string.
         */


        val p = Pattern.compile(regex)
        if (str == null) {
            return false
        }
        val m = p.matcher(str)
        return m.matches()
    }


    /**
     * Function to validate Time in 24 hour clock. Eg - "13:05” is a valid time in 24 hour format.
     * "24:00” , “10:60” , "10:15 PM” are not valid 24 Hour format time
     */
    fun isValidTime(time: String?): Boolean {
        val regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]"
        val p = Pattern.compile(regex)
        if (time == null) {
            return false
        }
        val m = p.matcher(time)
        return m.matches()
    }



    /**
     * Valid Indian Mobile Number -
     * 1) The first digit should contain number between 7 to 9.
     * 2) The rest 9 digit can contain any number between 0 to 9.
     * 3) The mobile number can have 11 digits also by including 0 at the starting.
     * 4) The mobile number can be of 12 digits also by including 91 at the starting
     */
    fun isValidIndianNumber(s: String): Boolean {
        val p = Pattern.compile("(0/91)?[7-9][0-9]{9}")
        val m = p.matcher(s)
        return m.find() && m.group() == s
    }

}