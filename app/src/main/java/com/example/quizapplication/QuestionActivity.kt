package com.example.quizapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
import android.content.Intent
import androidx.core.view.isVisible

class   QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0

    private var currentposition:Int=1
    private var questionList:ArrayList<QuestionData> ?=null
    private var selectedOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(setData.name);

        questionList=setData.getQuestion()

        setQuestion()
        opt_1.setOnClickListener{
            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener{
            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener{
            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener{
            selectedOptionStyle(opt_4,4)
        }
        submit.setOnClickListener {


                var tv1 = findViewById<TextView>(R.id.opt_1)
                var tv2 = findViewById<TextView>(R.id.opt_2)
                var tv3 = findViewById<TextView>(R.id.opt_3)
                var tv4 = findViewById<TextView>(R.id.opt_4)



            if(selectedOption!=0)
            {
                val  question=questionList!![currentposition-1]
                if(selectedOption!=question.correct_ans)
                {
                    setColor(selectedOption,R.drawable.wrong_question_option)
                }else{
                    score++;
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if(currentposition==questionList!!.size)
                    submit.text="FINISH"
                else{
                    submit.text="GO TO NEXT"


                }
                opt_1.isEnabled=false
                opt_2.isEnabled=false
                opt_3.isEnabled=false
                opt_4.isEnabled=false
                
            }else {
                currentposition++
                when {
                    currentposition<=questionList!!.size -> {
                        setQuestion()
                        submit.text="Submit"
                        opt_1.isEnabled=true
                        opt_2.isEnabled=true
                        opt_3.isEnabled=true
                        opt_4.isEnabled=true
                    }
                    else -> {
                       var intent= Intent(this,Result::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption=0
        }

    }
    fun setColor(opt: Int,color:Int){
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4 .background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun setQuestion(){

        var question = questionList!![currentposition-1]
        setOptionStyle()

        progress_bar.progress=currentposition
        progress_bar.max=questionList!!.size
        progress_text.text="${currentposition}"+"/"+"${questionList!!.size}"
        question_text.text=question.question
        opt_1.text=question.option_one
        opt_2.text=question.option_two
        opt_3.text=question.option_three
        opt_4.text=question.option_four

    }
    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for (op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }
    fun selectedOptionStyle(view:TextView,opt:Int){
        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        //view.setTextColor(Color.parseColor("#00000"))
        view.setTextColor(Color.parseColor("#000000"))
    }
}