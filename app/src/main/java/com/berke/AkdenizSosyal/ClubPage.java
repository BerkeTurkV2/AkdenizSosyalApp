package com.berke.AkdenizSosyal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ClubPage extends Fragment {

    private ListView mListView;
    private ArrayAdapter adapter;
    private String[] clubs = {"A.Ü.Tenis Topluluğu", "Afro Antalya Topluluğu", "Ahbap Akdeniz Üniversitesi Topluluğu", "Akdeniz Akademi Topluluğu",
            "Akdeniz Kalite Elçileri Topluluğu", "Akdeniz Okul Öncesi Eğitimi Topluluğu","Akdeniz Reklam Topluluğu", "Akdeniz Üniversitesi Genetik Topluluğu",
            "Akdeniz Üniversitesi Marka Topluluğu", "Akdeniz Üniversitesi Motorsiklet Topluluğu", "Akdeniz Üniversitesi Psikoloji Topluluğu", "Akdeniz Üniversitesi Animasyon Topluluğu",
            "Akdeniz Üniversitesi Sualtı Topluluğu", "Akdeniz Üniversitesi Tasarım Topluluğu", "Akdeniz Üniversitesi Tiyatro Topluluğu", "Akdeniz ve Türk Uygarlıkları Araştırma Topluluğu",
            "Anime ve Cosplay Topluluğu", "Antalya 1207 Türk Okçuluğu", "Antalya Genç Hukukçular", "Antalya Gezi ve Doğa Sporları Topluluğu", "Ar-Ge ve Yüksek Teknoloji Topluluğu"};

    private String[] clubType = {"Spor Topluluğu" , "Kültür Topluluğu", "Kültür Topluluğu","Kültür Topluluğu","Kültür Topluluğu","Kültür Topluluğu"};
    private String[] clubOpeningDate = {"Açılış tarihi: 10.10.2017", "Açılış tarihi: 11.06.2019", "Açılış tarihi: 01.11.2018", "Açılış tarihi: 10.10.2017", "Açılış tarihi: 11.03.2022", "Açılış tarihi: 06.03.2019"};
    private String[] clubAdvisor = {"Danışman: Doç.Dr. Mustafa ALTINKÖK (Dahili: 6844)","Danışman: Prof. Dr. Orhan ÖZÇATALBAŞ (Dahili: 2476)","Danışman: Prof. Dr. Erol EROĞLU (Dahili: 6078)","Danışman: Doç. Dr. Sabri YILMAZ (Dahili: 3428)","Danışman: Prof. Dr. Orhan ÖZÇATALBAŞ (Dahili: 2476)","Danışman: Dr. Öğr. Üyesi Yakup YILDIRIM (Dahili: 4653)"};
    private String[] clubDesc = {"Tenis sporunu öğrencilerle buluşturmak bu sporu yeni insanlarla tanıştırıp inceliklerini öğretmek. Öğrencilerin sporu sevmesine ve ilgi duymasını sağlayarak toplumda sporun sağlıklı yaşama katkısı hakkında farkındalık yaratmak. Öğrencileri takım ve takım ruhunu yaşatarak zamanlarını daha kaliteli geçirmelerine katkıda bulunmak.",
            "Akdeniz Üniversitesinde okuyan tüm Afrikalı öğrencileri bir çatı altında toplamak. Eğitim boyunca aralarında kaynaşma ve dayanışma sağlamak. Kültürel sportif ve bilimsel etkinlikleri düzenleyerek, aldıkları eğitime değişik renkler katarak küresel bakış açısına sahip olmalarını sağlamak",
            "Topluluk üyelerinin araştırıcı ve yaratıcı niteliklere sahip kişiler olarak yetişmelerine katkıda bulunarak yardımlaşma bilincini güçlendirmeyi sağlamak. Çevre ve hayvan hakları konusunda çalışmalar yapmak.",
            "Eğitim alanında yapılan kurumsal ve uygulamalı araştırmalar yoluyla bilgi üretimine katkıda bulunarak, bireylerin eğitim hakları, eşitlik ve insan haklarına saygı temelinde toplumun eğitim sorunlarını irdelemek ve çözüm önerileri geliştirmek.",
            "Akdeniz Üniversitesi'nin kalite odaklı çalışma sistemini topluluk üyelerimize ve tüm öğrencilerimize benimseterek, yükseköğretim alanında kalite kültürünü yaygınlaştırmak. Öğrenci eğitim-öğretim süreçlerinde kalite süreçlerinin geliştirilmesine katkı sunmak.",
            "Okul öncesi eğitimin veriminin artırılmasına yönelik çalışmalar yapmak, okul öncesi eğitimle ilgili yeni gelişmelerin takibinde olmak ve araştırmak. Okul öncesine katılacak adayların uyum sürecine yardımcı olmak."};

    private Intent detailsIntent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_club_page, container, false);


        mListView = (ListView)rootView.findViewById(R.id.clubpage_listview);
        // adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clubs);
        mListView.setAdapter(new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1 , clubs));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                detailsIntent = new Intent(getActivity(),DetailsClub.class);
                detailsIntent.putExtra("ClubName", clubs[i]);
                detailsIntent.putExtra("ClubType", clubType[i]);
                detailsIntent.putExtra("ClubOpeningDate", clubOpeningDate[i]);
                detailsIntent.putExtra("ClubAdvisor", clubAdvisor[i]);
                detailsIntent.putExtra("ClubDesc", clubDesc[i]);
                startActivity(detailsIntent);
            }
        });
        return rootView;
    }
}