package com.example.firstaid.data.datasource

import com.example.firstaid.data.model.DistrictHelpline
import com.example.firstaid.data.model.EmergencyCategory
import com.example.firstaid.data.model.FirstAidGuide
import com.example.firstaid.data.model.StepItem

object FirstAidData {

    val guides = listOf(
        FirstAidGuide(
            id = "bleeding",
            category = EmergencyCategory.BLEEDING,
            titleChichewa = "Mukutuluka Magazi Ambiri",
            titleEnglish = "Severe Bleeding",
            summaryChichewa = "Zoyenera kuchita mwamsanga pakatuluka magazi pa bala kapena ngozi.",
            summaryEnglish = "Immediate steps to control heavy external bleeding from cuts or injury.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Ikani Thandizo la Bango kapena Salu Yoyera",
                    titleEnglish = "Apply Direct Pressure",
                    instructionChichewa = "Ikani nsalu yoyera pa bala ndikukankhira mwamphamvu ndi manja anuyani kwa mphindi 5-10 popanda kuchotsa.",
                    instructionEnglish = "Press firmly on the wound with a clean cloth or bandage for 5-10 minutes without releasing.",
                    warningNoteChichewa = "Musachotse nsalu yoyamba ngati yalowa magazi, ikani ina pamwamba pake.",
                    warningNoteEnglish = "Do not remove the first cloth if soaked through; place another clean cloth over it."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Kwezani Mbali Yovulala Pamwamba",
                    titleEnglish = "Elevate the Wounded Limb",
                    instructionChichewa = "Ngati ali wosathyoka fupa, kwezani dzenje kapena mwendo ukhale pamwamba pa mlingo wa mtima.",
                    instructionEnglish = "If no fracture is suspected, raise the bleeding arm or leg above heart level."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Manga ndi Mangani Bango",
                    titleEnglish = "Secure with Bandage",
                    instructionChichewa = "Mangani nsalu kapena bango lokwera popanda kutseka magazi kwathunthu pa thupi.",
                    instructionEnglish = "Wrap firmly with a bandage to maintain constant pressure until help arrives."
                ),
                StepItem(
                    stepNumber = 4,
                    titleChichewa = "Ithanani ndi Chipatala Mwamsanga",
                    titleEnglish = "Call Emergency Helplines",
                    instructionChichewa = "Imbanirani chipatala cha boma kapena ambulansi mwamsanga ngati magazi sakuyima.",
                    instructionEnglish = "Call local ambulance or hospital immediately if bleeding persists."
                )
            ),
            dosChichewa = listOf(
                "Gwiritsani ntchito nsalu yoyera nthawi zonse.",
                "Gonekani wodwala pansi mwamtendere.",
                "Sungani wodwala ali ndi kufunda."
            ),
            dosEnglish = listOf(
                "Always use a clean cloth or gloves if available.",
                "Keep the casualty calm and lying down.",
                "Maintain body temperature with a blanket."
            ),
            dontsChichewa = listOf(
                "Musapake dothi, phulusa kapena mankhwala opanda chilolezo pa bala.",
                "Musachotse chinthu cholowera m'bala (monga mpeni kapena galasi)."
            ),
            dontsEnglish = listOf(
                "Do not put dirt, ash, or unapproved herbs into the wound.",
                "Do not remove embedded objects such as glass or knife fragments."
            ),
            emergencyTipChichewa = "Kukankhira pa bala ndi chinsinsi chofunika kwambiri choyimitsira magazi!",
            emergencyTipEnglish = "Firm, steady pressure directly on the wound saves lives!"
        ),
        FirstAidGuide(
            id = "burns",
            category = EmergencyCategory.BURNS,
            titleChichewa = "Kupsa Ndi Moto kapena Madzi Otentha",
            titleEnglish = "Burns & Scalds",
            summaryChichewa = "Thandizo loyamba pamene munthu wapsa ndi madzi otentha, mafuta kapena moto.",
            summaryEnglish = "First aid steps for heat, boiling water, hot oil, or flame burns.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Thirirani Madzi Ouzira (Osati Yasi)",
                    titleEnglish = "Cool with Running Water",
                    instructionChichewa = "Thirirani madzi abwinobwino pa malo opsa kwa mphindi 10-20 kuti kupsako kusiye mozama.",
                    instructionEnglish = "Cool the burn under clean, cool running water for 10-20 minutes.",
                    warningNoteChichewa = "Musagwiritse ntchito ayezi (ice) kapena madzi ozizira kwambiri.",
                    warningNoteEnglish = "Never use ice or freezing water directly on burns."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Chotsani Zovala kapena Zokongoletsera",
                    titleEnglish = "Remove Tight Items Gently",
                    instructionChichewa = "Chotsani makatundu, mphete kapena zovala kufupi ndi malo opsa ngati sizinamamatire pa khungu.",
                    instructionEnglish = "Gently remove rings, watches, or clothing around the burn if not stuck."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Phimbani ndi Nsalu Yosamamatira",
                    titleEnglish = "Cover Cleanly",
                    instructionChichewa = "Phimbani malo opsa ndi nsalu yoyera, yoonda komanso yotayirira.",
                    instructionEnglish = "Cover the burned area loosely with a sterile, dry cloth."
                )
            ),
            dosChichewa = listOf(
                "Gwiritsani ntchito madzi oyera nthawi yomweyo.",
                "Tetezani chilonda ku pfumbi ndi ntchentche."
            ),
            dosEnglish = listOf(
                "Use clean room-temperature water immediately.",
                "Keep the wound covered and clean from dust."
            ),
            dontsChichewa = listOf(
                "Musapake Mafuta a Koloboyi, Mafuta Ophikira, kapena Mankhwala a Mano!",
                "Musaphulitze thupsa kapena ziphuphu zamadzi pa khungu."
            ),
            dontsEnglish = listOf(
                "Do NOT apply cooking oil, toothpaste, butter, or vaseline on fresh burns!",
                "Do NOT pop blisters on the skin."
            ),
            emergencyTipChichewa = "Madzi oyera ali pafupi ndi othandiza kwambiri pa kupsa kulikonse!",
            emergencyTipEnglish = "Cool running water is the most effective burn treatment available."
        ),
        FirstAidGuide(
            id = "fractures",
            category = EmergencyCategory.FRACTURES,
            titleChichewa = "Kuthyoka kapena Kupotoka Fupa",
            titleEnglish = "Fractures & Sprains",
            summaryChichewa = "Zochita pofuna kuteteza fupa lothyoka kuti lisamawawa kapena kuwonongeka kwambiri.",
            summaryEnglish = "How to immobilize broken bones and manage severe sprains.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Musagwedeze Mbali Yothyokayo",
                    titleEnglish = "Immobilize the Injury",
                    instructionChichewa = "Gonekani wodwala pansi ndipo musasunthitse mkono kapena mwendo wothyoka.",
                    instructionEnglish = "Keep the injured person calm and hold the affected limb completely still."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Ikani Mtaba (Splint)",
                    titleEnglish = "Apply a Support Splint",
                    instructionChichewa = "Gwiritsani ntchito katsitsimuko kowongoka (nthungululu/kamatabwa) kumanga ndi nsalu ku mbali ya fupa loyenera.",
                    instructionEnglish = "Use straight padded sticks or cardboard tied with cloth to support the limb."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pititsani ku Chipatala",
                    titleEnglish = "Transport Safely",
                    instructionChichewa = "Tengani wodwala kupita ku chipatala choyandikana mwamtendere popanda kumugwedeza.",
                    instructionEnglish = "Transport the patient gently to the nearest health center or district hospital."
                )
            ),
            dosChichewa = listOf("Chitsikitsirani mbali yovulalayo panjira yopita kuchipatala."),
            dosEnglish = listOf("Keep the injured limb fully supported during movement."),
            dontsChichewa = listOf("Musayese kuwongola fupa kapena kulilumikiza nokha!"),
            dontsEnglish = listOf("Do NOT try to push broken bones back into place yourself!"),
            emergencyTipChichewa = "Kukhala chete popanda kusuntha kumachepetsa ululu kwambiri.",
            emergencyTipEnglish = "Immobilization prevents further nerve and muscle damage."
        ),
        FirstAidGuide(
            id = "choking",
            category = EmergencyCategory.CHOKING,
            titleChichewa = "Kutsamwa Ndi Chakudya kapena Chinthu",
            titleEnglish = "Choking First Aid",
            summaryChichewa = "Zoyenera kuchita mwamsanga pakatsekeka m'mmero mwa mwana kapena munthu wamkulu.",
            summaryEnglish = "Life-saving back blows and abdominal thrusts for airway obstruction.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Komani Nkhonya Kumbuyo (Back Blows)",
                    titleEnglish = "Give 5 Back Blows",
                    instructionChichewa = "Weramisani wodwala patsogolo ndipo munyonde pa msana pakati pa masamba ka 5 ndi chikhato cha dzanja.",
                    instructionEnglish = "Lean the person forward and give 5 firm back blows between shoulder blades using heel of hand."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Kankhani M'mimba (Abdominal Thrusts)",
                    titleEnglish = "Give 5 Abdominal Thrusts",
                    instructionChichewa = "Gwirani m'mimba pamwamba pa nthomba ndi kumwamba pa msana, kankhirani m'mwamba ndi m'kati ka 5.",
                    instructionEnglish = "Stand behind, place fist above navel, pull inward and upward 5 times."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Bwerezani Mpaka Chinthucho Chituluke",
                    titleEnglish = "Repeat Until Airway Clears",
                    instructionChichewa = "Bwerezani nkhonya 5 zakumbuyo ndi 5 zakumimba mpaka chakudyacho chituluke kapena ambulansi ifike.",
                    instructionEnglish = "Alternate 5 back blows and 5 abdominal thrusts until object dislodges."
                )
            ),
            dosChichewa = listOf("Limbikitsani munthuyo kuwukola chifuwa ngati akukhoza kulankhula."),
            dosEnglish = listOf("Encourage coughing if the casualty can still breathe or speak."),
            dontsChichewa = listOf("Musamupatse madzi pomwe wakana kumeza chinthucho!"),
            dontsEnglish = listOf("Do NOT give water to someone actively choking!"),
            emergencyTipChichewa = "Kutsamwa kumafuna kuthandizidwa mumphindi imodzi yokha!",
            emergencyTipEnglish = "Act immediately within seconds when someone cannot breathe."
        ),
        FirstAidGuide(
            id = "cpr_heart",
            category = EmergencyCategory.CPR_HEART_ATTACK,
            titleChichewa = "Kuyima Mtima / Kupopa Chachifuwa (CPR)",
            titleEnglish = "CPR & Heart Attack Emergency",
            summaryChichewa = "Chithandizo chadzidzidzi munthu akagwera pansi ndikusiya kupuma kapena mtima kuyima.",
            summaryEnglish = "Cardiopulmonary Resuscitation (CPR) and heart attack management.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Fufuzani Kuyankha ndi Kupuma",
                    titleEnglish = "Check Responsiveness & Breathing",
                    instructionChichewa = "Gwedezani pamasamba ndikufuula: 'Kodi muli bwino?'. Ngati sakuyankha komanso sakupuma, itanani ambulansi (998).",
                    instructionEnglish = "Shake shoulders and ask loudly: 'Are you okay?'. If unresponsive and not breathing, call 998."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Popani Chachifuwa ka 30 (30 Chest Compressions)",
                    titleEnglish = "Perform 30 Chest Compressions",
                    instructionChichewa = "Ikani zikhato za manja pachingwe cha chifuwa, kankhirani mwamphamvu pansi ka 30 pamlingo wachangu.",
                    instructionEnglish = "Place heel of hands in center of chest. Push hard and fast 30 times."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Tsirani Mpweya ka 2 (2 Rescue Breaths)",
                    titleEnglish = "Give 2 Rescue Breaths",
                    instructionChichewa = "Tsekerezeni mphuno, tsegulani kamwa ndikuthira mpweya wonse ka 2 mpaka chifuwa chikwere.",
                    instructionEnglish = "Pinch nose, seal mouth over casualty's mouth, and blow firmly 2 times."
                )
            ),
            dosChichewa = listOf("Tsatirani mlingo wa popa ka 100 pa mphindi iliyonse."),
            dosEnglish = listOf("Push at a rate of 100-120 compressions per minute."),
            dontsChichewa = listOf("Musasiye popa mpaka ambulansi kapena dokotala afike."),
            dontsEnglish = listOf("Do NOT stop CPR until medical help arrives or casualty recovers."),
            emergencyTipChichewa = "CPR yachangu imasunga ubongo kukhala wamoyo!",
            emergencyTipEnglish = "Immediate CPR doubles or triples survival chances."
        ),
        FirstAidGuide(
            id = "stroke",
            category = EmergencyCategory.STROKE,
            titleChichewa = "Kufa Ziwalo Zadzidzidzi (Stroke)",
            titleEnglish = "Stroke Emergency",
            summaryChichewa = "Chithandizo cholembera chizindikiro cha FAST pa munthu yemwe mtsempha wamubongo watsekeka.",
            summaryEnglish = "FAST stroke recognition and emergency dispatch protocol.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "F - Nkhope (Face): Funsani Kusekerera",
                    titleEnglish = "Face Drooping",
                    instructionChichewa = "Funsani munthuyo kusekerera. Onani ngati mbali imodzi ya nkhope yagwa pansi.",
                    instructionEnglish = "Ask casualty to smile. Check if one side of the face droops."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "A - Mikono (Arms): Funsani Kukuza Mikono",
                    titleEnglish = "Arm Weakness",
                    instructionChichewa = "Funsani kukuza mikono yonse iwiri. Ngati mkono umodzi ukugwera pansi ndiwochepa mphamvu.",
                    instructionEnglish = "Ask them to raise both arms. Check if one arm drifts downward."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "S - Kulankhula (Speech): Funsani Kuyankhula",
                    titleEnglish = "Speech Difficulty",
                    instructionChichewa = "Funsani kubwereza mawu osavuta. Ngati pakamwa pamilira kapena sakutha kulankhula bwino.",
                    instructionEnglish = "Ask them to repeat a simple phrase. Listen for slurred speech."
                ),
                StepItem(
                    stepNumber = 4,
                    titleChichewa = "T - Nthawi (Time): Pitani ku Chipatala Mwamsanga",
                    titleEnglish = "Time to Call Ambulance",
                    instructionChichewa = "Ngati ali ndi zizindikirozi, imbanirani chipatala kapena ambulansi ya Boma nthawi yomweyo!",
                    instructionEnglish = "Call emergency medical services immediately if any FAST sign is present."
                )
            ),
            dosChichewa = listOf("Mugonekeni ali chete ndikuthandiza khosi kukhala pamwamba."),
            dosEnglish = listOf("Keep the casualty lying down with head slightly elevated."),
            dontsChichewa = listOf("Musamupatse chakudya, madzi kapena mankhwala a aspirin m'kamwa!"),
            dontsEnglish = listOf("Do NOT offer food, drink, or medications by mouth."),
            emergencyTipChichewa = "Kufika kuchipatala mkati mwa maola 3 kumasunga moyo wathunthu!",
            emergencyTipEnglish = "Rapid stroke treatment minimizes permanent brain damage."
        ),
        FirstAidGuide(
            id = "seizures",
            category = EmergencyCategory.SEIZURES,
            titleChichewa = "Kukomoka kwa Khunyu (Seizures / Epilepsy)",
            titleEnglish = "Seizures & Epilepsy",
            summaryChichewa = "Zoyenera kuchita munthu akudwala khunyu ndikuthuntha thupi pansi.",
            summaryEnglish = "Safe management for epileptic fits and convulsive seizures.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Sungani Chilengedwe Chotetezeka",
                    titleEnglish = "Clear Surrounding Hazards",
                    instructionChichewa = "Chotsani zinthu zakuthwa, mipando ndi miyala pafupi naye kuti asadzigunde.",
                    instructionEnglish = "Move away sharp objects, furniture, or hard items to prevent impact injuries."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Ikani Nsalu Yofewa Pansi pa Mutu",
                    titleEnglish = "Cushion the Head",
                    instructionChichewa = "Ikani mwasamusi kapena nsalu yofewa pansi pa mutu pake kuti ugonde bwino.",
                    instructionEnglish = "Place a folded jacket or soft pad under their head."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Tembenuzirani pa Mbali akaleka kuthuntha",
                    titleEnglish = "Turn onto Side (Recovery Position)",
                    instructionChichewa = "Akasidza kuthuntha, mutembenuzire pa mbali (Recovery Position) kuti mpweya ulowe bwino.",
                    instructionEnglish = "Once convulsions stop, roll casualty gently onto their side to keep airway open."
                )
            ),
            dosChichewa = listOf("Yembekezani mwamtendere mpaka adzuke yekha."),
            dosEnglish = listOf("Time the seizure and remain calm until they regain full consciousness."),
            dontsChichewa = listOf(
                "Musamumuze kapena kumugwira mwamphamvu pomwe akuthuntha!",
                "Musamulowetse supuni, choko kapena zala m'kamwa mwake!"
            ),
            dontsEnglish = listOf(
                "Do NOT restrain their movements or hold them down!",
                "Do NOT insert spoons, sticks, or fingers into their mouth!"
            ),
            emergencyTipChichewa = "Kusagwira munthu akudwala khunyu kumateteza mafupa osathyoka!",
            emergencyTipEnglish = "Never put anything in a seizing person's mouth."
        ),
        FirstAidGuide(
            id = "allergies",
            category = EmergencyCategory.ALLERGIES,
            titleChichewa = "Kusamva Mankhwala kapena Zovala (Anaphylaxis)",
            titleEnglish = "Severe Allergies & Anaphylactic Shock",
            summaryChichewa = "Chithandizo chamfundo munthu akatupa nkhope ndi kukanika kupuma chifukwa cha allergic Reaction.",
            summaryEnglish = "First aid for acute severe allergic reactions and breathing distress.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Gwiritsani Ntchito EpiPen ngati Ilipo",
                    titleEnglish = "Administer Auto-Injector (EpiPen)",
                    instructionChichewa = "Ngati ali ndi jakisoni wa Epinephrine (EpiPen), imangani pa mwendo wina kwa masekondi 10.",
                    instructionEnglish = "If an epinephrine auto-injector is available, press firmly into outer thigh for 10 seconds."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Mukhazikitsani Pansi Mwamtendere",
                    titleEnglish = "Position Casualty Comfortably",
                    instructionChichewa = "Mukhazikitsani pansi pausedi ngati akukanika kupuma, kapena kwezani mapazi ngati wafooka.",
                    instructionEnglish = "Sit casualty upright if breathing is hard, or elevate legs if feeling dizzy."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pitani ku Chipatala Mwamsanga",
                    titleEnglish = "Rush to Hospital",
                    instructionChichewa = "Tengani wodwala kupita ku chipatala cha Boma popanda kuchedwa.",
                    instructionEnglish = "Transport immediately to nearest emergency medical facility."
                )
            ),
            dosChichewa = listOf("Sungani wodwala ali m'mpweya wabwino."),
            dosEnglish = listOf("Monitor breathing and keep casualty calm."),
            dontsChichewa = listOf("Musamupatse chakudya kapena madzi ngati akukanika kumeza."),
            dontsEnglish = listOf("Do NOT give oral drinks if airway is swelling."),
            emergencyTipChichewa = "Anaphylaxis imafuna chithandizo cha m'chipatala mwachangu!",
            emergencyTipEnglish = "Epinephrine is the primary life-saving drug for anaphylaxis."
        ),
        FirstAidGuide(
            id = "animal_bites",
            category = EmergencyCategory.ANIMAL_BITES,
            titleChichewa = "Kulumwa Ndi Galu kapena Chiwanda (Rabies)",
            titleEnglish = "Dog & Animal Bites (Rabies Hazard)",
            summaryChichewa = "Chithandizo choyenera pa kulumwa ndi galu kapena chilombo pofuna kupewa chiwanda (Rabies).",
            summaryEnglish = "Wound cleansing and post-exposure rabies prevention for animal bites.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Sambitsani Bala ndi Madzi ndi Sopo ka 15",
                    titleEnglish = "Wash Thoroughly with Soap & Water",
                    instructionChichewa = "Sambitsani bala la galu ndi madzi ambiri komanso sopo kwa mphindi 15 zosayima.",
                    instructionEnglish = "Wash wound immediately under running water with soap for 15 full minutes."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Pakanani Mankhwala Ophera Magazi (Antiseptic)",
                    titleEnglish = "Apply Antiseptic Solution",
                    instructionChichewa = "Sukurutsani pa chilondacho ndi Betadine kapena Spirit kuphetsa majeremusi.",
                    instructionEnglish = "Apply iodine or alcohol antiseptic solution to the disinfected wound."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pitani ku Chipatala Kukupeza Katemera wa Chiwanda",
                    titleEnglish = "Get Rabies Vaccine at Hospital",
                    instructionChichewa = "Pitani ku chipatala cha Boma mwamsanga pofuna kulandira Katemera wa Rabies (Anti-Rabies Vaccine).",
                    instructionEnglish = "Go to district hospital immediately for Rabies Post-Exposure Prophylaxis (PEP)."
                )
            ),
            dosChichewa = listOf("Tsimikizani ngati galuyo ali ndi katemera kwanu."),
            dosEnglish = listOf("Report the biting animal to local veterinary/health officers."),
            dontsChichewa = listOf("Musasoke kapena kutseka bala la galu mwamsanga popanda adokotala!"),
            dontsEnglish = listOf("Do NOT stitch animal bite wounds tightly without medical debridement."),
            emergencyTipChichewa = "Kusamba ndi sopo kwa mphindi 15 kupha kachilombo ka chiwanda!",
            emergencyTipEnglish = "Immediate soap washing destroys the Rabies virus outer envelope."
        ),
        FirstAidGuide(
            id = "heat_stroke",
            category = EmergencyCategory.HEAT_STROKE,
            titleChichewa = "Kutenthedwa Kwambiri Ndi Dzuwa (Heat Stroke)",
            titleEnglish = "Heat Stroke & Overheating",
            summaryChichewa = "Chithandizo munthu akatopa ndikukomoka chifukwa cha kutentha kwa dzuwa m'munda kapena m'msewu.",
            summaryEnglish = "Cooling techniques for extreme heat exhaustion and heat stroke.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Musutseni ku Mfundo ya Mthunzi",
                    titleEnglish = "Move to Cool Shade",
                    instructionChichewa = "Mutsogolereni munthuyo kupita pamthunzi kapena m'chipinda chokhala ndi mpweya.",
                    instructionEnglish = "Move casualty out of direct sunlight into a cool, shaded place."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Thirirani Madzi Ouzira ndi Kusamba Khungu",
                    titleEnglish = "Cool the Body Rapidly",
                    instructionChichewa = "Ikani nsalu zonyowa pamutu, nkhosi, pa khwapa ndi m'ntchafu mwake.",
                    instructionEnglish = "Apply cool wet cloths to head, neck, armpits, and groin."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Mupatseni Madzi Ochepa Ngati Waumoyo",
                    titleEnglish = "Offer Small Sips of Water",
                    instructionChichewa = "Ngati akudzindikira, mupatseni madzi oyera ochepa ochepa kumwa.",
                    instructionEnglish = "If fully conscious, give small frequent sips of cool water or ORS."
                )
            ),
            dosChichewa = listOf("Leketsani zovala zakuda kapena zolemera."),
            dosEnglish = listOf("Fan the casualty to assist evaporative cooling."),
            dontsChichewa = listOf("Musamupatse mowa kapena mankhwala a aspirin!"),
            dontsEnglish = listOf("Do NOT offer sugary or alcoholic drinks."),
            emergencyTipChichewa = "Kuziziritsa thupi pakhwapa ndi nkhosi kumathetsa kutentha msanga!",
            emergencyTipEnglish = "Cooling armpits and neck lowers core body temperature quickly."
        ),
        FirstAidGuide(
            id = "asthma",
            category = EmergencyCategory.ASTHMA,
            titleChichewa = "Kukanika Kupuma (Asthma Attack)",
            titleEnglish = "Asthma Attack First Aid",
            summaryChichewa = "Zoyenera kuchita munthu wamukana kupuma chifukwa cha matenda a Asitima.",
            summaryEnglish = "Emergency inhaler administration and position for acute asthma.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Mukhazikitsani Chiwongolero M'wamba",
                    titleEnglish = "Sit Casualty Upright",
                    instructionChichewa = "Mukhazikitsani pansi pa mpando pausedi popanda kumugoneka pansi.",
                    instructionEnglish = "Help the person sit upright comfortably. Do NOT lay them down."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Patsani Mankhwala Awa (Blue Inhaler / Reliever)",
                    titleEnglish = "Administer Reliever Inhaler",
                    instructionChichewa = "Mupatseni pompano (blue inhaler) ka 4 ndi kupuma nthawi iliyonse.",
                    instructionEnglish = "Give 4 puffs of blue reliever inhaler, 1 puff at a time with 4 breaths each."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Yembekezani Mphindi 4 ndikubwereza ngati kuli kofunika",
                    titleEnglish = "Wait 4 Minutes & Repeat",
                    instructionChichewa = "Ngati sakupuma bwino patatha mphindi 4, mupatseninso pompano ka 4. Ngati zakukanika imbanirani ambulansi.",
                    instructionEnglish = "If no improvement after 4 minutes, give 4 more puffs. Call 998 if breathing remains difficult."
                )
            ),
            dosChichewa = listOf("Tsimikizani kuti panyumba pali mpweya wabwino."),
            dosEnglish = listOf("Reassure the person and encourage slow steady breathing."),
            dontsChichewa = listOf("Musamugoneke pansi pausedi chifukwa zimatsina chachifuwa!"),
            dontsEnglish = listOf("Do NOT lie an asthma casualty down."),
            emergencyTipChichewa = "Kukhala pausedi kumatsegula mapapu kulandira mpweya!",
            emergencyTipEnglish = "Sitting upright maximizes lung expansion capacity."
        ),
        FirstAidGuide(
            id = "diabetes",
            category = EmergencyCategory.DIABETES,
            titleChichewa = "Shuga Wokwera kapena Wogwa (Diabetic Emergency)",
            titleEnglish = "Diabetic Emergency (Hypoglycemia)",
            summaryChichewa = "Zoyenera kuchita munthu wa shuga akayamba kunjenjemera kapena kufooka.",
            summaryEnglish = "Managing acute low blood sugar (hypoglycemia) in diabetic patients.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Mupatseni Shuga kapena Fanta/Juice",
                    titleEnglish = "Give Fast-Acting Sugar",
                    instructionChichewa = "Ngati amakhoza kumeza, mupatseni supuni 3 za shuga, Fanta kapena madzi a shuga nthawi yomweyo.",
                    instructionEnglish = "If conscious and able to swallow, give 3 teaspoons of sugar, sweet juice, or soda."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Yembekezani Mphindi 10-15",
                    titleEnglish = "Rest for 10-15 Minutes",
                    instructionChichewa = "Muloleni kupumula. Ngati asanduke bwino, mupatseni chakudya chambiri (nsima kapena buledi).",
                    instructionEnglish = "Have them rest. Follow up with complex carbs like bread or a meal once improved."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pitani ku Chipatala Ngati Sakudzuka",
                    titleEnglish = "Seek Hospital Help if Unconscious",
                    instructionChichewa = "Ngati wakomoka kapena sakutha kumeza, pitani naye ku chipatala cha Boma mwamsanga.",
                    instructionEnglish = "If casualty becomes confused or unconscious, transport immediately to hospital."
                )
            ),
            dosChichewa = listOf("Sungani makapu kapena mapale a shuga pafupi."),
            dosEnglish = listOf("Keep quick sugar sources accessible for known diabetics."),
            dontsChichewa = listOf("Musamulowetse shuga m'kamwa ngati wakomoka kwathunthu!"),
            dontsEnglish = listOf("Do NOT force liquids or food if unconscious."),
            emergencyTipChichewa = "Kupatsa shuga munthu wa shuga kumathetsa ngozi ya imfoyi!",
            emergencyTipEnglish = "When in doubt in diabetes, giving sugar is safer."
        ),
        FirstAidGuide(
            id = "eye_injuries",
            category = EmergencyCategory.EYE_INJURIES,
            titleChichewa = "Kuvulala M'maso kapena Mankhwala M'maso",
            titleEnglish = "Eye Injuries & Chemical Splashes",
            summaryChichewa = "Chithandizo choyenera pfumbi, mchenga kapena mankhwala akalowa m'maso.",
            summaryEnglish = "Flushing and protecting eyes after trauma or chemical exposure.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Rukutsani ndi Madzi Oyera ka 15-20",
                    titleEnglish = "Flush with Clean Water for 15 Mins",
                    instructionChichewa = "Tsegulani diso ndikuthira madzi oyera nthawi zonse kwa mphindi 15-20.",
                    instructionEnglish = "Hold eyelid open and flush thoroughly with clean running water for 15-20 minutes."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Phimbani Diso ndi Salu Yoyera",
                    titleEnglish = "Cover Eye Loosely",
                    instructionChichewa = "Phimbani disolo ndi nsalu yoyera yosamanga kwambiri.",
                    instructionEnglish = "Cover the injured eye loosely with a clean pad or sterile cloth."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pitani ku Chipatala Cha Maso",
                    titleEnglish = "Seek Ophthalmic / Hospital Evaluation",
                    instructionChichewa = "Pitani ku chipatala cha Boma kuti dokotala wa maso ayang'ane disolo.",
                    instructionEnglish = "Go to hospital for professional eye examination."
                )
            ),
            dosChichewa = listOf("Rukutsani diso kuyambira pafupi ndi mphuno kupita kunja."),
            dosEnglish = listOf("Flush from inner eye corner outwards to protect the other eye."),
            dontsChichewa = listOf(
                "Musasisite diso ndi zala kapena nsalu ya pfumbi!",
                "Musachotse nsonga yapachitsulo yoloŵa m'diso!"
            ),
            dontsEnglish = listOf(
                "Do NOT rub the eye!",
                "Do NOT attempt to remove embedded metallic or glass objects."
            ),
            emergencyTipChichewa = "Kusisita diso pakhala chilonda kumawononga kupenya!",
            emergencyTipEnglish = "Immediate water flushing dilutes chemical burns."
        ),
        FirstAidGuide(
            id = "head_injury",
            category = EmergencyCategory.HEAD_INJURY,
            titleChichewa = "Kuvulala Mutu / Khosi (Head & Spinal Trauma)",
            titleEnglish = "Head & Spinal Injury",
            summaryChichewa = "Chithandizo chofunika pa munthu yemwe wagwa pamtengo kapena kugundidwa mutu.",
            summaryEnglish = "Spinal stabilization and concussion observation.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Musagwedeze Mutu ndi Khosi La Wodwala",
                    titleEnglish = "Keep Head & Spine Completely Still",
                    instructionChichewa = "Gwirani mutu ndi manja anuyani pansi kuti khosi lisagwedezeke panjira iliyonse.",
                    instructionEnglish = "Hold head manually in line with spine. Avoid turning or twisting neck."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Yimitsani Magazi pa Mutu Ngati Alipo",
                    titleEnglish = "Control Head Bleeding Gently",
                    instructionChichewa = "Ikani nsalu yoyera pa bala la mutu popanda kukankhira fupa lamutu pansi.",
                    instructionEnglish = "Apply light pressure with clean cloth without pressing into depressed skull fractures."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pititsani ku Chipatala cha Boma Pa Chotsatira",
                    titleEnglish = "Immobilize and Transport to Hospital",
                    instructionChichewa = "Tengani wodwala pa gango/thandiza lopanda kupinda khosi mpaka ku chipatala.",
                    instructionEnglish = "Transport casualty flat on a firm stretcher preserving neck alignment."
                )
            ),
            dosChichewa = listOf("Yang'anani ngati akusanza kapena akutuluka madzi m'makutu."),
            dosEnglish = listOf("Monitor alertness, speech, and pupil size continuously."),
            dontsChichewa = listOf("Musamutembenuze khosi kapena kumukhazika pansi mpando!"),
            dontsEnglish = listOf("Do NOT bend or twist the head or neck."),
            emergencyTipChichewa = "Kuteteza khosi kumathetsa kuwola kwa manjenje olumikiza thupi!",
            emergencyTipEnglish = "Manual inline stabilization prevents permanent paralysis."
        ),
        FirstAidGuide(
            id = "emergency_birth",
            category = EmergencyCategory.EMERGENCY_BIRTH,
            titleChichewa = "Kubeleka Mwadzidzidzi (Emergency Labor & Birth)",
            titleEnglish = "Emergency Labor & Unplanned Delivery",
            summaryChichewa = "Zoyenera kuchita mzimayi akayamba kubeleka m'njira kapena panyumba popanda namwino.",
            summaryEnglish = "Emergency field delivery steps and newborn care before arrival at health center.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Aneketsani Mzimayi pa Nsalu Yoyera",
                    titleEnglish = "Prepare Clean Dry Delivery Space",
                    instructionChichewa = "Gonekani mzimayi pausedi poyala nsalu zoyera, zofunda ndi kuthira madzi ofunda pafupi.",
                    instructionEnglish = "Lay mother on her back with knees bent over clean dry sheets or towels."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Gwirani Mutu wa Mwana Mwamutendere",
                    titleEnglish = "Support Baby's Head Gently",
                    instructionChichewa = "Mwana akatuluka, gwirani mutu ndi thupi lake mwamtendere popanda kumponda kapena kumupera.",
                    instructionEnglish = "Guide and support the baby's head and body gently as it emerges."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pukutani Mwana ndi Mumuphimbe pa Chifuwa cha Amayi",
                    titleEnglish = "Dry Baby & Skin-to-Skin Warmth",
                    instructionChichewa = "Pukutani mwana ndi nsalu yowuma, mpatseni amayi ake pachingwe cha chifuwa (Skin-to-Skin) kuti amve kufunda.",
                    instructionEnglish = "Wipe baby dry immediately, wrap in dry cloth, and place skin-to-skin on mother's chest."
                ),
                StepItem(
                    stepNumber = 4,
                    titleChichewa = "Pitani ku Chipatala cha Boma / Namwino",
                    titleEnglish = "Transport Mother & Baby to Health Center",
                    instructionChichewa = "Tengani amayi ndi mwana kupita ku chipatala cha Boma pofuna kudula lamba (cord) ndi namwino wophunzira.",
                    instructionEnglish = "Transport mother and baby safely to health center for professional cord cutting and care."
                )
            ),
            dosChichewa = listOf("Sungani mwana ndi amayi ake ali ndi kufunda nthawi zonse."),
            dosEnglish = listOf("Keep mother and newborn warm with clean blankets."),
            dontsChichewa = listOf("Musadule kapena kumanga lamba (cord) panyumba ndi mpeni wa pfumbi!"),
            dontsEnglish = listOf("Do NOT cut the umbilical cord with unsterilized blades at home!"),
            emergencyTipChichewa = "Kuyika mwana pachingwe cha amayi (Skin-to-skin) kumathetsa kuzizira wa mwana!",
            emergencyTipEnglish = "Immediate skin-to-skin contact prevents newborn hypothermia."
        )
    )

    // Complete Directory of ALL 28 Districts in Malawi (Southern, Central, and Northern Regions)
    val districts = listOf(
        DistrictHelpline("lilongwe", "Lilongwe", "Central Region", "Kamuzu Central Hospital (KCH)", "+265 1 756 999", "Lilongwe Police Station", "+265 1 753 333", "998 / +265 999 911 000"),
        DistrictHelpline("blantyre", "Blantyre", "Southern Region", "Queen Elizabeth Central Hospital (QECH)", "+265 1 874 333", "Blantyre Police Station", "+265 1 820 122", "998 / +265 888 911 000"),
        DistrictHelpline("zomba", "Zomba", "Southern Region", "Zomba Central Hospital", "+265 1 524 222", "Zomba Police Station", "+265 1 524 333", "998"),
        DistrictHelpline("mzuzu", "Mzuzu / Mzimba", "Northern Region", "Mzuzu Central Hospital", "+265 1 320 622", "Mzuzu Police Station", "+265 1 332 333", "998"),
        DistrictHelpline("mangochi", "Mangochi", "Southern Region", "Mangochi District Hospital", "+265 1 580 233", "Mangochi Police Station", "+265 1 580 333", "998"),
        DistrictHelpline("salima", "Salima", "Central Region", "Salima District Hospital", "+265 1 262 211", "Salima Police Station", "+265 1 262 333", "998"),
        DistrictHelpline("kasungu", "Kasungu", "Central Region", "Kasungu District Hospital", "+265 1 252 222", "Kasungu Police Station", "+265 1 252 333", "998"),
        DistrictHelpline("karonga", "Karonga", "Northern Region", "Karonga District Hospital", "+265 1 362 200", "Karonga Police Station", "+265 1 362 333", "998"),
        DistrictHelpline("dedza", "Dedza", "Central Region", "Dedza District Hospital", "+265 1 220 222", "Dedza Police Station", "+265 1 220 333", "998"),
        DistrictHelpline("nkhotakota", "Nkhotakota", "Central Region", "Nkhotakota District Hospital", "+265 1 292 233", "Nkhotakota Police Station", "+265 1 292 333", "998"),
        DistrictHelpline("nsanje", "Nsanje", "Southern Region", "Trinity & Nsanje District Hospital", "+265 1 480 222", "Nsanje Police Station", "+265 1 480 333", "998"),
        DistrictHelpline("chikwawa", "Chikwawa", "Southern Region", "Chikwawa District Hospital", "+265 1 420 211", "Chikwawa Police Station", "+265 1 420 333", "998"),
        DistrictHelpline("mulanje", "Mulanje", "Southern Region", "Mulanje Mission & District Hospital", "+265 1 462 233", "Mulanje Police Station", "+265 1 462 333", "998"),
        DistrictHelpline("thyolo", "Thyolo", "Southern Region", "Thyolo District Hospital", "+265 1 472 222", "Thyolo Police Station", "+265 1 472 333", "998"),
        DistrictHelpline("phalombe", "Phalombe", "Southern Region", "Phalombe District Hospital", "+265 1 455 211", "Phalombe Police Station", "+265 1 455 333", "998"),
        DistrictHelpline("machinga", "Machinga", "Southern Region", "Machinga District Hospital (Machinga/Liwonde)", "+265 1 542 222", "Machinga Police Station", "+265 1 542 333", "998"),
        DistrictHelpline("balaka", "Balaka", "Southern Region", "Balaka District Hospital", "+265 1 552 233", "Balaka Police Station", "+265 1 552 333", "998"),
        DistrictHelpline("neno", "Neno", "Southern Region", "Neno District Hospital", "+265 1 490 222", "Neno Police Station", "+265 1 490 333", "998"),
        DistrictHelpline("mwanza", "Mwanza", "Southern Region", "Mwanza District Hospital", "+265 1 440 211", "Mwanza Police Station", "+265 1 440 333", "998"),
        DistrictHelpline("ntcheu", "Ntcheu", "Central Region", "Ntcheu District Hospital", "+265 1 230 222", "Ntcheu Police Station", "+265 1 230 333", "998"),
        DistrictHelpline("dowa", "Dowa", "Central Region", "Dowa District Hospital", "+265 1 282 233", "Dowa Police Station", "+265 1 282 333", "998"),
        DistrictHelpline("ntchisi", "Ntchisi", "Central Region", "Ntchisi District Hospital", "+265 1 285 222", "Ntchisi Police Station", "+265 1 285 333", "998"),
        DistrictHelpline("mchinji", "Mchinji", "Central Region", "Mchinji District Hospital", "+265 1 242 211", "Mchinji Police Station", "+265 1 242 333", "998"),
        DistrictHelpline("rumphi", "Rumphi", "Northern Region", "Rumphi District Hospital", "+265 1 372 222", "Rumphi Police Station", "+265 1 372 333", "998"),
        DistrictHelpline("chitipa", "Chitipa", "Northern Region", "Chitipa District Hospital", "+265 1 382 200", "Chitipa Police Station", "+265 1 382 333", "998"),
        DistrictHelpline("nkhata_bay", "Nkhata Bay", "Northern Region", "Nkhata Bay District Hospital", "+265 1 352 222", "Nkhata Bay Police Station", "+265 1 352 333", "998"),
        DistrictHelpline("likoma", "Likoma Island", "Northern Region", "Likoma St. Peter's Hospital", "+265 1 356 211", "Likoma Police Post", "+265 1 356 333", "998"),
        DistrictHelpline("chiradzulu", "Chiradzulu", "Southern Region", "Chiradzulu District Hospital", "+265 1 615 222", "Chiradzulu Police Station", "+265 1 615 333", "998")
    )
}
