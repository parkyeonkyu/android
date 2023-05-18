package com.anyul.goodwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class SentenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("검정화면에 대충 흐니글씨 쓰면 명언같다.")
        sentenceList.add("사람에게 하나의 입과 두개의 귀가 잇는 것은 말하기보다 듣기를 두 배로 하라는 뜻이다")
        sentenceList.add("직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다 -엘버트 허버드")
        sentenceList.add("신은 용기있는자를 결코 버리지 않는다 -켄러")
        sentenceList.add("어리석은 자는 멀리서 행복을 찾고, 현명한 자는 자신의 발치에서 행복을 키워간다 -제임스 오펜하임")
        sentenceList.add("피할수 없으면 즐겨라 -로버트 엘리엇")
        sentenceList.add("오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아 간다, -앙드레 말로")
        sentenceList.add("행복은 습관이다,그것을 몸에 지니라 -허버드")
        sentenceList.add("성공의 비결은 단 한 가지, 잘할 수 있는 일에 광적으로 집중하는 것이다.- 톰 모나건")


        val sentenceAdapter = ListViewAdapter(sentenceList)
        val listview = findViewById<ListView>(R.id.sentenceListView);
        listview.adapter = sentenceAdapter
    }

}