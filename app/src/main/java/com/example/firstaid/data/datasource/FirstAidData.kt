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
            id = "accidents",
            category = EmergencyCategory.ACCIDENTS,
            titleChichewa = "Ngozi Zapa Msewu (Galimoto / Kabaza)",
            titleEnglish = "Road Traffic Accidents",
            summaryChichewa = "Momwe mungathandizire pa ngozi ya galimoto kapena njinga zamoto (kabaza).",
            summaryEnglish = "Safety and triage steps for road traffic emergencies in Malawi.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Sungani Chitetezo M'msewu",
                    titleEnglish = "Secure Scene Safety",
                    instructionChichewa = "Imitsani magalimoto ena ndikuchenjeza anthu omwe ali m'msewu.",
                    instructionEnglish = "Warn oncoming traffic and ensure the scene is safe before approaching."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Fufuzani Wodwala Ngati Waumoyo",
                    titleEnglish = "Check Breathing & Consciousness",
                    instructionChichewa = "Yang'anani ngati akupuma ndipo muthanani naye pa dzina.",
                    instructionEnglish = "Check if casualties are conscious and breathing normally."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Yimitsani Magazi Ambiri",
                    titleEnglish = "Control Major Bleeding",
                    instructionChichewa = "Gwiritsani ntchito nsalu zoyera kupondereza pamalo amene magazi akutuluka kwambiri.",
                    instructionEnglish = "Apply direct pressure to any catastrophic bleeding sites immediately."
                )
            ),
            dosChichewa = listOf("Imbanirani Apolisi ndi Ambulansi zapa Boma nthawi yomweyo."),
            dosEnglish = listOf("Call local police and emergency medical dispatch promptly."),
            dontsChichewa = listOf("Musagwedeze khosi la wodwala ngati palibe chiwopsezo cha moto."),
            dontsEnglish = listOf("Do NOT move casualties with potential neck/spine injuries unless in immediate fire danger."),
            emergencyTipChichewa = "Kusagwedeza khosi kuthetsa kuwola kwa manjenje!",
            emergencyTipEnglish = "Protect spinal alignment when moving road accident victims."
        ),
        FirstAidGuide(
            id = "drowning",
            category = EmergencyCategory.DROWNING,
            titleChichewa = "Kumira M'madzi (Nyanja / Mtsinje / Chitsime)",
            titleEnglish = "Drowning Response",
            summaryChichewa = "Chithandizo chamfundo chopulumutsa munthu yemwe wamira m'madzi.",
            summaryEnglish = "Resuscitation and recovery for near-drowning victims.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Mubweretseni M'mbali Mwamadzi",
                    titleEnglish = "Bring Casualty to Dry Ground",
                    instructionChichewa = "Mutsogolereni panja pa madzi popanda kudzaponya nokha mu ngozi.",
                    instructionEnglish = "Safely bring casualty onto land without endangering yourself."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Fufuzani Kupuma ndi Kupopa Chachifuwa (CPR)",
                    titleEnglish = "Check Breathing & Start CPR",
                    instructionChichewa = "Ngati sakupuma, tsirani mpweya ka 5 m'kamwa ndipo yambani kupopa pachingwe cha chifuwa ka 30.",
                    instructionEnglish = "If not breathing, give 5 rescue breaths and start 30 chest compressions."
                )
            ),
            dosChichewa = listOf("Muvula zovala zonyowa ndikumuphimba ndi nsalu yowuma."),
            dosEnglish = listOf("Remove wet clothing and keep casualty warm."),
            dontsChichewa = listOf("Musagwedeze munthu kutembenuza m'mimba mwa madzi."),
            dontsEnglish = listOf("Do NOT attempt to drain water from stomach by pressing violently."),
            emergencyTipChichewa = "Kuyambitsa kuthira mpweya pamfundo zachangu kumathetsa imfoyi!",
            emergencyTipEnglish = "Prompt rescue breathing is crucial for drowning casualties."
        ),
        FirstAidGuide(
            id = "snake_bites",
            category = EmergencyCategory.SNAKE_BITES,
            titleChichewa = "Kulumwa Ndi Njoka",
            titleEnglish = "Snake Bite First Aid",
            summaryChichewa = "Chithandizo choyenera pa kulumwa ndi njoka za ululu ku Malawi.",
            summaryEnglish = "Correct field management for venomous snake bites.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Khazikitsani Wodwala Bwino",
                    titleEnglish = "Keep Casualty Calm & Still",
                    instructionChichewa = "Gonekani wodwala pansi mwamtendere popanda kumulola kuthamanga kapena kuchita mantha.",
                    instructionEnglish = "Keep casualty still and calm; movement speeds venom circulation."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Chotsani Mphete kapena Zomanga",
                    titleEnglish = "Remove Constrictive Items",
                    instructionChichewa = "Chotsani nsapato, mabangili ndi mphete chifukwa malo olumwidwa azatupa.",
                    instructionEnglish = "Remove shoes, rings, and watches before swelling begins."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Manga Bango Yofewa (Pressure Immobilization)",
                    titleEnglish = "Apply Broad Firm Bandage",
                    instructionChichewa = "Mangani bango yofewa kuyambira pa zala kupita mwamba pa mkono kapena mwendo.",
                    instructionEnglish = "Wrap a wide broad bandage tightly over the bite site and entire limb."
                ),
                StepItem(
                    stepNumber = 4,
                    titleChichewa = "Pitani ku Chipatala Cha Boma Mwamsanga",
                    titleEnglish = "Get to Hospital Immediately",
                    instructionChichewa = "Tengani wodwala ku chipatala cha boma pofuna kupeza mankhwala a anti-venom.",
                    instructionEnglish = "Transport to hospital quickly for anti-venom assessment."
                )
            ),
            dosChichewa = listOf("Sungani malo olumwidwa pamunsi pa mlingo wa mtima."),
            dosEnglish = listOf("Keep the bitten limb below heart level."),
            dontsChichewa = listOf(
                "Musadule pa bala ndi mpeni kapena kufyonsa ululu ndi kamwa!",
                "Musamange lamba kapena chingwe chothina kwambiri (tourniquet) chopha khungu."
            ),
            dontsEnglish = listOf(
                "Do NOT cut the bite area or attempt to suck out venom!",
                "Do NOT use tight tourniquets that cut off arterial blood supply."
            ),
            emergencyTipChichewa = "Kukhala wosaguntha kumathandiza kuti ululu ungasamale msanga thupi lonse!",
            emergencyTipEnglish = "Immobilizing the bitten limb slows venom transport through lymphatics."
        ),
        FirstAidGuide(
            id = "fainting",
            category = EmergencyCategory.FAINTING,
            titleChichewa = "Kukomoka / Kutaya Chidziwitso",
            titleEnglish = "Fainting & Unconsciousness",
            summaryChichewa = "Zochita munthu akagwera pansi ndikukomoka chifukwa cha kutentha kapena kufooka.",
            summaryEnglish = "Managing sudden loss of consciousness and recovery position.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Gonekani Munthuyo ndi Kukuza Mapazi",
                    titleEnglish = "Lay Down & Elevate Legs",
                    instructionChichewa = "Gonekani pansi pausedi ndikukweza mapazi ake pamwamba pa masentimita 30.",
                    instructionEnglish = "Lay the person on their back and elevate legs about 12 inches."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Tsegulani Zovala Zothina ndi Kupatsa Mpweya",
                    titleEnglish = "Loosen Tight Clothes",
                    instructionChichewa = "Leketsani kachipewa, tsegulani kolara ndikutalitsa gulu la anthu poyembekezera mpweya.",
                    instructionEnglish = "Loosen collars, belts, and clear crowd for fresh air flow."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Mugonekeni Chadzanja Ngati Sakudzuka (Recovery Position)",
                    titleEnglish = "Place in Recovery Position",
                    instructionChichewa = "Tembenuzirani munthuyo pa mbali kuti ngati asanza asatsamwe.",
                    instructionEnglish = "Turn them onto their side if breathing to prevent choking on fluids."
                )
            ),
            dosChichewa = listOf("Lolani mpweya wabwino kulowa m'chipinda."),
            dosEnglish = listOf("Ensure good ventilation and shadow from hot sun."),
            dontsChichewa = listOf("Musamuthire madzi pa nkhope kapena kumumwetsa chilichonse asanadzuke!"),
            dontsEnglish = listOf("Do NOT splash water or force liquids down their throat while unconscious!"),
            emergencyTipChichewa = "Kukweza mapazi kumatumiza magazi ku ubongo mwamsanga!",
            emergencyTipEnglish = "Leg elevation quickly restores blood flow to the brain."
        ),
        FirstAidGuide(
            id = "poisoning",
            category = EmergencyCategory.POISONING,
            titleChichewa = "Apoizoni kapena Mankhwala Asewera",
            titleEnglish = "Poisoning Emergencies",
            summaryChichewa = "Zoyenera kuchita munthu akumwa poizoni, Paraquat kapena Mankhwala olakwika.",
            summaryEnglish = "Immediate steps for chemical, pesticide, or accidental drug poisoning.",
            steps = listOf(
                StepItem(
                    stepNumber = 1,
                    titleChichewa = "Dziwani Chinthu Chodyedwacho",
                    titleEnglish = "Identify the Substance",
                    instructionChichewa = "Sungani botolo kapena phukusi la mankhwalayo kuti mudzaonetse madokotala.",
                    instructionEnglish = "Keep the container, bottle, or label of the ingested substance for doctors."
                ),
                StepItem(
                    stepNumber = 2,
                    titleChichewa = "Rukutsani Kamwa ndi Madzi",
                    titleEnglish = "Rinse Mouth Thoroughly",
                    instructionChichewa = "Sukurutsani m'kamwa ndi madzi oyera popanda kumeza.",
                    instructionEnglish = "Rinse mouth with clean water without swallowing."
                ),
                StepItem(
                    stepNumber = 3,
                    titleChichewa = "Pitani ku Chipatala Mwamsanga",
                    titleEnglish = "Rush to Health Center",
                    instructionChichewa = "Pitani ku chipatala mwamsanga pamodzi ndi botolo la mankhwalayo.",
                    instructionEnglish = "Rush casualty to nearest hospital with the poison container."
                )
            ),
            dosChichewa = listOf("Mungosunga botolo kapena zotsalira za chilonda."),
            dosEnglish = listOf("Bring the original poison container to the hospital."),
            dontsChichewa = listOf("Musakakamize munthuyo kusanza pokhapokha adokotala atanena!"),
            dontsEnglish = listOf("Do NOT induce vomiting unless explicitly instructed by medical professionals!"),
            emergencyTipChichewa = "Kusanza poizoni wa petulo kapena asidi kumawononga pa kukhosi!",
            emergencyTipEnglish = "Vomiting corrosive chemicals causes severe secondary throat burns."
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
