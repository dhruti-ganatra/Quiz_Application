package com.example.quizapplication

object setData {
    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1 = QuestionData(
            question =  "What is the capital of India",
            id = 1,
            option_one = "UP",
            option_two = "MP",
            option_three = "New Delhi",
            option_four = "Lucknow",
            correct_ans = 3
        )
        var q2 = QuestionData(
            question =  "Who is the  first Indian Woman in Space ?",
            id = 2,
            option_one = "Kalpana Chawla",
            option_two = "Sunita Williams",
            option_three = "Koneru Humpy",
            option_four = "None of the above",
            correct_ans = 1
        )
        var q3 = QuestionData(
            question =  "Who Wrote the Indian National Anthem ?",
            id = 3,
            option_one = "Bankim Chandra Chatterji",
            option_two = "Rabindranath Tagore",
            option_three = "Swami Vivekanand",
            option_four = "None of the above",
            correct_ans = 2
        )
        var q4 = QuestionData(
            question =  "Who was the first president of India ?",
            id = 4,
            option_one = "Abdul Kalam",
            option_two = "Lal Bahadur Shastri",
            option_three = "Dr. Rajendra Prasad",
            option_four = "Zakir Hussain",
            correct_ans = 3
        )
        var q5 = QuestionData(
            question =  "Who built the Jama Masjid",
            id = 5,
            option_one = "Jahangir",
            option_two = "Akbar",
            option_three = "Imam Bhkhari",
            option_four = "Shah Jahan",
            correct_ans = 4
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }

}