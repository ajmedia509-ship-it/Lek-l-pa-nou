package com.example.data

import androidx.compose.ui.graphics.Color
import com.example.model.LessonModule
import com.example.model.LessonSection
import com.example.model.TradeCourse
import com.example.model.TradeIcon
import com.example.model.Workshop

object TradeRepository {

    val categories: List<String> = listOf(
        "Tout",
        "Teknoloji",
        "Atizana",
        "Teknik"
    )

    val trades: List<TradeCourse> = listOf(
        TradeCourse(
            id = "coding",
            title = "Pwogramasyon & Web",
            subtitle = "Kreye sit wèb ak aplikasyon modèn",
            category = "Teknoloji",
            description = "Aprann kijan pou bati sit wèb pwòp ak HTML, CSS, ak baz JavaScript. Kou sa a fèt pou jèn ki vle travay a distans oswa kreye pwòp biznis dijital yo an Ayiti.",
            icon = TradeIcon.CODING,
            accentColor = Color(0xFF0EA5E9),
            pdfGuideTitle = "Gid_Debitan_Pwogramasyon_Web.pdf",
            modules = listOf(
                LessonModule(
                    id = "coding_1",
                    moduleNumber = 1,
                    title = "Modil 1: Baz yo",
                    durationMinutes = 12,
                    summary = "Konprann kijan entènèt la fonksyone, sa HTML ak CSS ye, epi kijan yon navigatè li kòd ou.",
                    sections = listOf(
                        LessonSection(
                            heading = "Kisa ki yon sit wèb?",
                            body = "Chak fwa ou louvri yon sit sou telefòn ou oswa òdinatè w, navigatè a (tankou Chrome) ap li twa kalite fichye prensipal: HTML pou estrikti tèks ak imaj yo, CSS pou koulè ak prezantasyon, epi JavaScript pou fè paj la reyaji lè ou klike sou bouton.",
                            practicalTip = "Kòmanse pa wè HTML tankou skelèt yon kay, CSS tankou penti ak dekorasyon, epi JavaScript tankou elektrisite ki limen limyè yo."
                        ),
                        LessonSection(
                            heading = "Premye baliz HTML ou yo",
                            body = "HTML itilize baliz ant parantèz kwoche. Pa egzanp, <h1> kreye yon gwo tit, <p> kreye yon paragraf, epi <button> kreye yon bouton. Chak baliz ki louvri dwe fèmen ak yon ba oblik, tankou </p>."
                        )
                    )
                ),
                LessonModule(
                    id = "coding_2",
                    moduleNumber = 2,
                    title = "Modil 2: Zouti ou bezwen",
                    durationMinutes = 10,
                    summary = "Enstale zouti gratis pou ekri kòd sou òdinatè oswa telefòn Android san ou pa depanse yon goud.",
                    sections = listOf(
                        LessonSection(
                            heading = "Editè kòd gratis",
                            body = "Si ou gen yon òdinatè (menm si li pa twò pisan), Visual Studio Code (VS Code) se pi bon zouti gratis pou ekri kòd. Si ou gen sèlman yon telefòn Android, ou ka itilize aplikasyon tankou Acode oswa Spck Editor pou teste HTML ak CSS dirèkteman.",
                            practicalTip = "Kreye yon katab ki rele 'PwojeMwen' sou aparèy ou a pou w pa janm pèdi fichye kòd ou yo."
                        ),
                        LessonSection(
                            heading = "Resous pou aprann san entènèt",
                            body = "Ou ka telechaje dokimantasyon MDN oswa sove paj egzanp yo lokalman. Konsa, menm lè entènèt la fèb oswa pa gen kouran, ou ka kontinye pratike nan kay la."
                        )
                    )
                ),
                LessonModule(
                    id = "coding_3",
                    moduleNumber = 3,
                    title = "Modil 3: Premye Pratik",
                    durationMinutes = 18,
                    summary = "Bati premye paj prezantasyon pèsonèl ou (CV sou entènèt) etap pa etap.",
                    sections = listOf(
                        LessonSection(
                            heading = "Etap 1: Kreye fichye index.html",
                            body = "Louvri editè ou a epi ekri estrikti debaz la: <!DOCTYPE html>, <html>, <head> pou tit la, epi <body> pou sa moun ap wè sou ekran an. Ajoute non ou nan yon <h1> ak metye ou nan yon <p>."
                        ),
                        LessonSection(
                            heading = "Etap 2: Mete estil ak CSS",
                            body = "Ajoute koulè fon ble fonse (#0F172A) ak tèks blan pou li fasil pou li, epi yon bouton jòn (#F59E0B) ak tèks 'Kontakte m sou WhatsApp'. Se konsa anpil devlopè jèn Ayisyen kòmanse vann premye sit yo bay ti komès lokal!",
                            practicalTip = "Teste paj ou a sou ekran telefòn anvan tout bagay, paske plis pase 85% Ayisyen itilize entènèt la sou telefòn."
                        )
                    )
                ),
                LessonModule(
                    id = "coding_4",
                    moduleNumber = 4,
                    title = "Modil 4: Jwenn Premye Kliyan ou",
                    durationMinutes = 14,
                    summary = "Kijan pou prezante travay ou bay ti biznis nan katye w epi fikse premye pri ou.",
                    sections = listOf(
                        LessonSection(
                            heading = "Bati 3 egzanp pwojè",
                            body = "Anvan ou chèche kliyan, kreye yon sit pou yon restoran imajinè, yon boutik rad, ak yon salon kwafè. Montre ekran sa yo sou telefòn ou lè w ap pale ak pwopriyetè biznis yo.",
                            practicalTip = "Pa tann ou konn tout bagay pou kòmanse. Yon sit senp ki pwòp epi ki konekte ak WhatsApp biznis lan deja vo lajan."
                        )
                    )
                )
            )
        ),
        TradeCourse(
            id = "graphic_design",
            title = "Konsepsyon Grafik",
            subtitle = "Logo, afich, ak imaj pou rezo sosyal",
            category = "Atizana",
            description = "Mèt prensip koulè, tipografi, ak konpozisyon pou kreye bèl afich piblisite, logo biznis, ak vizyèl pou Instagram, Facebook, ak WhatsApp Status.",
            icon = TradeIcon.GRAPHIC_DESIGN,
            accentColor = Color(0xFFEC4899),
            pdfGuideTitle = "Gid_Debitan_Konsepsyon_Grafik.pdf",
            modules = listOf(
                LessonModule(
                    id = "design_1",
                    moduleNumber = 1,
                    title = "Modil 1: Baz yo",
                    durationMinutes = 11,
                    summary = "Dekouvri 4 règ lò nan konsepsyon grafik: Kontras, Aliyeman, Espas blanch, ak Yerachi.",
                    sections = listOf(
                        LessonSection(
                            heading = "Yerachi vizyèl ak kontras",
                            body = "Lè moun gade yon afich, je yo dwe wè mesaj ki pi enpòtan an nan 2 segonn. Sèvi ak yon gwo tit klè, epi kenbe enfòmasyon segondè yo (dat, adrès, telefòn) pi piti men lizib.",
                            practicalTip = "Evite mete plis pase 3 koulè prensipal ak 2 stil ekriti sou yon sèl afich. Sa fè travay la parèt pwofesyonèl imedyatman."
                        ),
                        LessonSection(
                            heading = "Koulè ki pale ak emosyon",
                            body = "Ble fonse bay konfyans ak serye; jòn/zoranj bay enèji ak atansyon; vèt raple nati ak lajan. Toujou asire tèks la gen bon kontras ak fon an."
                        )
                    )
                ),
                LessonModule(
                    id = "design_2",
                    moduleNumber = 2,
                    title = "Modil 2: Zouti ou bezwen",
                    durationMinutes = 9,
                    summary = "Pi bon aplikasyon gratis sou telefòn ak òdinatè pou desine tankou yon pwofesyonèl.",
                    sections = listOf(
                        LessonSection(
                            heading = "Zouti sou telefòn ak òdinatè",
                            body = "Pou kòmanse vit sou telefòn, Canva ak PixelLab ekselan pou afich ak kat biznis. Pou travay ki pi avanse ak logo vektoryèl, Figma (gratis sou entènèt) ak Photopea (menm jan ak Photoshop gratis) se zouti ki gen anpil pouvwa.",
                            practicalTip = "Toujou ekspòte logo yo an fòma PNG san fon (transparent) pou kliyan an ka mete l sou nenpòt foto."
                        )
                    )
                ),
                LessonModule(
                    id = "design_3",
                    moduleNumber = 3,
                    title = "Modil 3: Premye Pratik",
                    durationMinutes = 15,
                    summary = "Kreye yon afich pwomosyon kare (1080x1080) pou yon ti biznis manje lokal.",
                    sections = listOf(
                        LessonSection(
                            heading = "Konstwi afich la etap pa etap",
                            body = "Chwazi fòma 1080x1080 piksèl. Mete yon bon foto pwodwi a nan sant la oswa sou bò dwat la. Sou bò gòch la, ekri yon tit kout tankou 'Gwo Pwomosyon Samdi!', mete pri a nan yon ti badj jòn klere, epi mete nimewo WhatsApp la anba a.",
                            practicalTip = "Kite ase espas vid toutotou tèks la (omwen 10% maj) pou afich la pa parèt toufe."
                        )
                    )
                ),
                LessonModule(
                    id = "design_4",
                    moduleNumber = 4,
                    title = "Modil 4: Prepare Fichye pou Enprime",
                    durationMinutes = 12,
                    summary = "Aprann diferans ant RGB pou ekran ak CMYK pou enprimri pou koulè ou yo pa soti fènwa.",
                    sections = listOf(
                        LessonSection(
                            heading = "Rezolusyon ak fòma enprimri",
                            body = "Pou ekran telefòn, 72 DPI sifi. Men pou banyè, kat vizit, oswa mayo, toujou travay nan 300 DPI epi sove an PDF kalite siperyè pou enprimri a ka bay yon rezilta nèt."
                        )
                    )
                )
            )
        ),
        TradeCourse(
            id = "auto_mechanics",
            title = "Mekanik Oto",
            subtitle = "Antretyen motè, fren, ak dyagnostik",
            category = "Teknik",
            description = "Aprann baz mekanik otomobil ki pi itil an Ayiti: chanjman lwil, sistèm refwadisman, fren, batri, ak kijan pou detekte pwoblèm motè san devine.",
            icon = TradeIcon.AUTO_MECHANICS,
            accentColor = Color(0xFFEF4444),
            pdfGuideTitle = "Gid_Debitan_Mekanik_Oto.pdf",
            modules = listOf(
                LessonModule(
                    id = "mech_1",
                    moduleNumber = 1,
                    title = "Modil 1: Baz yo",
                    durationMinutes = 14,
                    summary = "Konprann 4 tan yon motè gazolin, wòl lwil motè, ak sistèm refwadisman an.",
                    sections = listOf(
                        LessonSection(
                            heading = "Kijan yon motè 4-tan fonksyone",
                            body = "Preske tout machin ki sikile yo itilize motè 4-tan: Admisyon (lè ak gaz antre), Konpresyon (piston an peze yo), Konbisyon/Eksplozyon (bouji a bay etensèl), epi Echapman (lafimen an soti). Lè yon motè gen pwoblèm pou l pran, se youn nan 3 bagay sa yo ki manke: lè, gaz, oswa etensèl.",
                            practicalTip = "Toujou tcheke nivo lwil ak nivo dlo/coolant lè motè a frèt anvan ou kòmanse nenpòt verifikasyon."
                        ),
                        LessonSection(
                            heading = "Sistèm refwadisman an",
                            body = "Nan chalè Ayiti a, radyatè a, tèmosta a, ak vantilatè a dwe toujou pwòp. Pa janm louvri bouchon radyatè a lè motè a cho!"
                        )
                    )
                ),
                LessonModule(
                    id = "mech_2",
                    moduleNumber = 2,
                    title = "Modil 2: Zouti ou bezwen",
                    durationMinutes = 11,
                    summary = "Lis zouti esansyèl pou yon apranti mekanisyen ak ekipman sekirite obligatwa.",
                    sections = listOf(
                        LessonSection(
                            heading = "Twous zouti debaz la",
                            body = "Ou bezwen yon seri kle plat ak kle bwat (8mm rive 22mm), yon kle filtre lwil, yon krik ak de chandèl sekirite (jack stands), yon miltimèt dijital pou tcheke batri ak fizib, ak yon eskanè OBD2 pou li kòd erè machin modèn yo.",
                            practicalTip = "Pa janm antre anba yon machin ki kenbe sèlman ak yon krik idwolik. Toujou mete chandèl sekirite anba chasi a."
                        )
                    )
                ),
                LessonModule(
                    id = "mech_3",
                    moduleNumber = 3,
                    title = "Modil 3: Premye Pratik",
                    durationMinutes = 16,
                    summary = "Pwosedi konplè pou fè yon vidanj (chanjman lwil ak filtre) epi tcheke plakèt fren.",
                    sections = listOf(
                        LessonSection(
                            heading = "Fè yon vidanj pwòp",
                            body = "1) Kite motè a tyèd pou lwil la koule fasil. 2) Mete yon kivèt anba katè a epi devise boulon vidanj lan. 3) Chanje filtre lwil la apre ou fin pase yon ti lwil fre sou jwenti kawotchou nouvo filtre a. 4) Mete lwil ki koresponn ak rekòmandasyon manifakti a (pa egzanp 5W-30 oswa 10W-40) epi verifye nivo a ak jòj la.",
                            practicalTip = "Pa jete vye lwil motè nan rigòl! Sere l nan galon pou resiklaj oswa pou garaj ki gen pwen koleksyon."
                        )
                    )
                ),
                LessonModule(
                    id = "mech_4",
                    moduleNumber = 4,
                    title = "Modil 4: Dyagnostik Batri & Altènatè",
                    durationMinutes = 12,
                    summary = "Sèvi ak yon miltimèt pou konnen si pwoblèm demaraj la soti nan batri a oswa altènatè a.",
                    sections = listOf(
                        LessonSection(
                            heading = "Tès vòltaj senp",
                            body = "Yon batri ki bon dwe bay anviwon 12.6 Vòlt lè motè a etenn. Lè ou limen motè a, altènatè a dwe chaje l ant 13.8V ak 14.4V. Si vòltaj la rete anba 12.5V lè motè a ap mache, altènatè a pa chaje."
                        )
                    )
                )
            )
        ),
        TradeCourse(
            id = "tailoring",
            title = "Kouti & Mòd",
            subtitle = "Mezi, patron, ak koud rad pwofesyonèl",
            category = "Atizana",
            description = "Dekouvri atizay kouti modèn ak kreyasyon mòd. Aprann pran mezi egzak, koupe twal san gaspiye, ak koud jip, chemiz, ak inifòm lekòl ki byen chita.",
            icon = TradeIcon.TAILORING,
            accentColor = Color(0xFF8B5CF6),
            pdfGuideTitle = "Gid_Debitan_Kouti_ak_Mod.pdf",
            modules = listOf(
                LessonModule(
                    id = "tailor_1",
                    moduleNumber = 1,
                    title = "Modil 1: Baz yo",
                    durationMinutes = 12,
                    summary = "Aprann pran mezi kò a kòrèkteman ak konprann sans fil twal la (droit-fil).",
                    sections = listOf(
                        LessonSection(
                            heading = "Pran mezi san erè",
                            body = "Yon bèl rad kòmanse ak bon mezi. Mezi prensipal yo se: tou pwatrin, tou tay, tou anch, lajè zepòl, longè manch, ak longè total la. Toujou kenbe riban mezi a dwat men san sere l twò fò sou kò kliyan an.",
                            practicalTip = "Toujou ajoute 1.5 cm pou kouti sou chak bò patron ou anvan ou koupe twal la."
                        ),
                        LessonSection(
                            heading = "Rekonèt twal yo",
                            body = "Koton ak popelin fasil anpil pou debitan koud. Twal ki elastik (jersey) mande yon zegwi espesyal (pwent wonn) pou li pa kase fil la."
                        )
                    )
                ),
                LessonModule(
                    id = "tailor_2",
                    moduleNumber = 2,
                    title = "Modil 2: Zouti ou bezwen",
                    durationMinutes = 10,
                    summary = "Ekipman debaz pou monte ti atelye kouti pa w lakay ou.",
                    sections = listOf(
                        LessonSection(
                            heading = "Zouti obligatwa pou kòmanse",
                            body = "Ou ap bezwen: yon bon sizo tayè (ki dwe koupe twal sèlman, pa papye!), yon riban mezi, lakre tayè, eping, yon dekoud-vit, yon fè a pase ak vapè, ak yon machin a koud ki pwòp epi ki byen wile.",
                            practicalTip = "Fè a pase a se sekrè tout gwo koutirye: pase chak kouti apre ou fin koud li pou rad la ka plat epi pwòp."
                        )
                    )
                ),
                LessonModule(
                    id = "tailor_3",
                    moduleNumber = 3,
                    title = "Modil 3: Premye Pratik",
                    durationMinutes = 17,
                    summary = "Koud yon bèl sak koton (tote bag) ak yon jip dwat senp pou pratike kouti dwat.",
                    sections = listOf(
                        LessonSection(
                            heading = "Metrize kouti dwat ak zig-zag",
                            body = "Anvan ou koupe yon rad pou yon kliyan, pran yon rès twal epi trase liy dwat ak liy koub ak lakre. Pratike koud sou liy yo san fil an premye, apre sa ak fil, toutpandan w ap gade gid ki sou plak machin nan olye w gade zegwi a.",
                            practicalTip = "Toujou fè 3 pwen bak (point d'arrêt) nan kòmansman ak nan fen chak kouti pou fil la pa janm dekoud."
                        )
                    )
                ),
                LessonModule(
                    id = "tailor_4",
                    moduleNumber = 4,
                    title = "Modil 4: Finisyon ak Pri Vant",
                    durationMinutes = 11,
                    summary = "Kijan pou kalkile pri twal, tan travay ou, ak pwofi pou biznis kouti w la rantab.",
                    sections = listOf(
                        LessonSection(
                            heading = "Kalkile pri sèvis ou",
                            body = "Pa janm bliye mete pri fil, zip, bouton, kouran/gaz, ak tan ou pase ap koupe ak pase rad la nan pri final la. Yon fòmil senp se: Pri Materyèl + (Èdtan Travay × Tarif Ou) + Maj pou antretyen atelye a."
                        )
                    )
                )
            )
        ),
        TradeCourse(
            id = "electrical",
            title = "Elektrisite Batiman",
            subtitle = "Enstalasyon kay, panno solè, ak sekirite",
            category = "Teknik",
            description = "Aprann prensip elektrisite nan kay, kijan pou li yon sikwi, enstale priz ak entèriptè, epi entegre sistèm enèji solè ak envètè san danje.",
            icon = TradeIcon.ELECTRICAL,
            accentColor = Color(0xFFF59E0B),
            pdfGuideTitle = "Gid_Debitan_Elektrisite_Batiman.pdf",
            modules = listOf(
                LessonModule(
                    id = "elec_1",
                    moduleNumber = 1,
                    title = "Modil 1: Baz yo",
                    durationMinutes = 13,
                    summary = "Konprann Vòlt (V), Anpè (A), Wat (W), ak diferans ant Faz, Nèt, ak Tè.",
                    sections = listOf(
                        LessonSection(
                            heading = "Twa gran mezi elektrisite yo",
                            body = "Imajine dlo nan yon tiyo: Vòlt (V) se presyon dlo a (nan kay Ayiti se souvan 110V-120V oswa 220V); Anpè (A) se kantite dlo k ap koule; Wat (W) se puisans total aparèy la ap konsome (W = V × A).",
                            practicalTip = "Toujou konnen konbyen Wat yon aparèy rale anvan ou chwazi gwosè fil ak disjonktè a. Pa egzanp, yon frijidè oswa yon fè a pase mande fil ki pi epè (12 AWG) pase anpoul limyè (14 AWG)."
                        ),
                        LessonSection(
                            heading = "Kòd koulè fil yo",
                            body = "Nan estanda ki pi komen an Ayiti: Nwa oswa Wouj se Faz (kouran cho), Blan se Nèt (retou), epi Vèt oswa Kuiv toutouni se Tè (pwoteksyon)."
                        )
                    )
                ),
                LessonModule(
                    id = "elec_2",
                    moduleNumber = 2,
                    title = "Modil 2: Zouti ou bezwen",
                    durationMinutes = 10,
                    summary = "Zouti izole ak enstriman mezi pou travay pwòp e san aksidan.",
                    sections = listOf(
                        LessonSection(
                            heading = "Zouti ki pwoteje lavi w",
                            body = "Chak elektrisyen dwe gen: yon pens koupe izole 1000V, yon pens pou retire po fil (stripper), yon seri tounvis izole, yon detektè vòltaj san kontak, yon miltimèt dijital, gan izole, ak soulye kawotchou.",
                            practicalTip = "Pa janm travay ak yon zouti ki gen manch kawotchou a chire oswa fann."
                        )
                    )
                ),
                LessonModule(
                    id = "elec_3",
                    moduleNumber = 3,
                    title = "Modil 3: Premye Pratik",
                    durationMinutes = 16,
                    summary = "Monte yon sikwi limyè senp ak entèriptè epi verifye koneksyon yo anvan ou mete kouran.",
                    sections = listOf(
                        LessonSection(
                            heading = "Règ sekirite nimewo 1",
                            body = "Anvan ou touche nenpòt fil: 1) Koupe disjonktè prensipal la. 2) Verifye ak detektè vòltaj la ke pa gen kouran ditou. 3) Mete yon ti nòt sou bwat disjonktè a pou pèsonn pa relimen l pandan w ap travay.",
                            practicalTip = "Entèriptè a dwe TOUJOU koupe fil Faz la (nwa/wouj), pa janm fil Nèt la, pou pa gen vòltaj nan douy lanp lan lè limyè a etenn."
                        )
                    )
                ),
                LessonModule(
                    id = "elec_4",
                    moduleNumber = 4,
                    title = "Modil 4: Baz Enèji Solè & Envètè",
                    durationMinutes = 15,
                    summary = "Kijan panno solè, kontwolè chaj (MPPT), batri, ak envètè konekte ansanm.",
                    sections = listOf(
                        LessonSection(
                            heading = "Kat eleman yon sistèm solè",
                            body = "Panno solè a pwodui kouran DC -> Kontwolè MPPT a regle chaj la pou pwoteje batri yo -> Batri yo estoke enèji a -> Envètè a transfòme kouran DC a an kouran AC pou aparèy nan kay la. Sa se youn nan sektè ki gen plis demann an Ayiti jodi a!"
                        )
                    )
                )
            )
        ),
        TradeCourse(
            id = "barber_beauty",
            title = "Kwafè & Estetik",
            subtitle = "Koupe modèn, bab, ak swen pwofesyonèl",
            category = "Atizana",
            description = "Aprann teknik koupe cheve modèn (fade/degrade), swen bab, ijyèn rigoureux nan salon, ak jesyon eksperyans kliyan pou fè salon pa w mache byen.",
            icon = TradeIcon.BARBER_BEAUTY,
            accentColor = Color(0xFF14B8A6),
            pdfGuideTitle = "Gid_Debitan_Kwafe_ak_Estetik.pdf",
            modules = listOf(
                LessonModule(
                    id = "barber_1",
                    moduleNumber = 1,
                    title = "Modil 1: Baz yo",
                    durationMinutes = 11,
                    summary = "Konprann nimewo sabo machin yo, fòm tèt kliyan yo, ak prensip ijyèn nan salon.",
                    sections = listOf(
                        LessonSection(
                            heading = "Ijyèn anvan tout bagay",
                            body = "Kliyan yo chwazi yon kwafè ki pwòp. Toujou dezenfekte lam machin yo ak alkòl oswa espre Barbicide ant chak kliyan, chanje lam razwa a devan kliyan an (toujou itilize yon lam nèf!), epi bale cheve yo regilyèman.",
                            practicalTip = "Yon sèvyèt pwòp ak yon bon espre fre nan fen koupe a fè kliyan an santi li jwenn yon sèvis VIP."
                        ),
                        LessonSection(
                            heading = "Konprann sabo (guards) yo",
                            body = "Sabo #0.5 (1.5mm), #1 (3mm), #1.5 (4.5mm), ak #2 (6mm) se baz tout degrade. Lè ou konn kisa chak nimewo bay, ou p ap janm koupe cheve kliyan an twò kout san ou pa vle."
                        )
                    )
                ),
                LessonModule(
                    id = "barber_2",
                    moduleNumber = 2,
                    title = "Modil 2: Zouti ou bezwen",
                    durationMinutes = 9,
                    summary = "Chwazi bon machin koupe, trimmer pou fè tras, sizo, ak pwodwi swen.",
                    sections = listOf(
                        LessonSection(
                            heading = "Ekipman esansyèl pou kòmanse",
                            body = "Ou bezwen yon machin prensipal ak levye reglabl (clipper), yon ti machin presizyon pou fè kouto/kontou (trimmer), yon pòt-lam, peny plat, bwòs dous pou netwaye kou, ak yon kap pwòp.",
                            practicalTip = "Mete 2 gout lwil espesyal sou dan machin nan chak swa apre ou fin netwaye l ak ti bwòs la pou motè a pa chofe epi lam yo dire lontan."
                        )
                    )
                ),
                LessonModule(
                    id = "barber_3",
                    moduleNumber = 3,
                    title = "Modil 3: Premye Pratik",
                    durationMinutes = 15,
                    summary = "Metòd 3 etap pou reyalize yon bèl degrade (Fade) san mak liy di.",
                    sections = listOf(
                        LessonSection(
                            heading = "Teknik degrade san tras",
                            body = "1) Trase premye liy gid ou a ak machin nan san sabo (levye fèmen). 2) Monte yon dwèt pi wo ak sabo #1 la. 3) Efase liy ki nan mitan an lè w ap jwe ak levye a nan mwatye pozisyon ak kwen lam la sèlman (teknik 'flick out').",
                            practicalTip = "Travay ak limyè ki klè epi gade tèt kliyan an nan glas la souvan pou wè si de bò yo simetrik."
                        )
                    )
                ),
                LessonModule(
                    id = "barber_4",
                    moduleNumber = 4,
                    title = "Modil 4: Fidelize Kliyan ou yo",
                    durationMinutes = 10,
                    summary = "Kijan pou itilize WhatsApp ak foto anvan/apre pou ranpli chèz ou chak semèn.",
                    sections = listOf(
                        LessonSection(
                            heading = "Maketing ak bon sèvis",
                            body = "Mande pèmisyon kliyan yo pou w pran yon bèl foto koupe a epi poste l sou Estati WhatsApp ou ak TikTok/Instagram. Sèvi ak randevou sou WhatsApp pou moun pa pèdi tan ap tann."
                        )
                    )
                )
            )
        )
    )

    val workshops: List<Workshop> = listOf(
        Workshop(
            id = "ws_coding",
            tradeTitle = "Pwogramasyon & Web",
            title = "Atelye Pratik: Bati & Vann Sit Wèb nan 4 Semèn",
            instructorName = "Enj. Widler Jean-Baptiste",
            instructorCredential = "Devlopè Full-Stack • 8 lane eksperyans",
            location = "Pòtoprens (Petyonvil) & Anliy sou Zoom",
            duration = "4 Semèn Entansif (3 fwa/semèn)",
            priceHtg = 7500,
            nextCohort = "Pwochen Gwoup: 8 Desanm",
            spotsLeft = 6,
            includedItems = listOf(
                "Sètifika Konpetans Ofisyèl Aprann Metye",
                "Mentora dirèk sou 2 pwojè reyèl pou pòtfolyo w",
                "Modèl kontra ak fakti an Kreyòl/Franse pou kliyan",
                "Gwoup WhatsApp prive pou sipò ak òf travay"
            ),
            whatsappPhone = "50937004510",
            whatsappPrefillMessage = "Bonjou ekip Aprann Metye! Mwen ta renmen enskri nan atelye avanse 'Pwogramasyon & Web' (7,500 HTG). Kijan m ka konfime plas mwen?"
        ),
        Workshop(
            id = "ws_design",
            tradeTitle = "Konsepsyon Grafik",
            title = "Kanp Pratik: Idantite Vizyèl & Piblisite Biznis",
            instructorName = "Mèt Fabiola Desir",
            instructorCredential = "Direktris Atistik • 10 lane eksperyans",
            location = "Delma / Anliy",
            duration = "3 Semèn Pratik",
            priceHtg = 6000,
            nextCohort = "Pwochen Gwoup: 12 Desanm",
            spotsLeft = 5,
            includedItems = listOf(
                "Sètifika Pratik Konsepsyon Grafik",
                "Pakèt 50+ modèl afich ak polis karaktè pwofesyonèl",
                "Revizyon chak travay ou dirèkteman ak mentò a",
                "Atelye sou kijan pou chaje kliyan an HTG ak USD"
            ),
            whatsappPhone = "50937004510",
            whatsappPrefillMessage = "Bonjou ekip Aprann Metye! Mwen enterese nan fòmasyon avanse 'Konsepsyon Grafik' (6,000 HTG). Tanpri voye detay peman an ban mwen."
        ),
        Workshop(
            id = "ws_mechanics",
            tradeTitle = "Mekanik Oto",
            title = "Atelye Garaj: Dyagnostik Elektwonik & Motè Modèn",
            instructorName = "Mèt Jean-Claude Pierre",
            instructorCredential = "Mèt Mekanisyen Sètifye • 15 lane nan garaj",
            location = "Kafou & Tabarre (Garaj Patnè)",
            duration = "6 Semèn sou Tèren an",
            priceHtg = 9500,
            nextCohort = "Pwochen Gwoup: 15 Desanm",
            spotsLeft = 4,
            includedItems = listOf(
                "Sètifika Mekanik Pratik & Stage nan Garaj",
                "Pratik reyèl sou machin ak eskanè OBD2",
                "Mayo atelye ak gid teknik enprime",
                "Rekòmandasyon pou estaj nan garaj patnè yo"
            ),
            whatsappPhone = "50937004510",
            whatsappPrefillMessage = "Bonjou ekip Aprann Metye! Mwen vle enskri nan atelye garaj 'Mekanik Oto' (9,500 HTG). Èske gen plas toujou?"
        ),
        Workshop(
            id = "ws_tailoring",
            tradeTitle = "Kouti & Mòd",
            title = "Atelye Kreyasyon: Patron, Rob & Chemiz sou Mezi",
            instructorName = "Madam Nadège Toussaint",
            instructorCredential = "Kreyatris Mòd • Fondatris Atelye Lakay",
            location = "Okap & Pòtoprens",
            duration = "5 Semèn Pratik",
            priceHtg = 6500,
            nextCohort = "Pwochen Gwoup: 10 Desanm",
            spotsLeft = 7,
            includedItems = listOf(
                "Sètifika Kouti Pwofesyonèl",
                "Twous baz: riban, lakre tayè, ak règ koub",
                "Ou pati ak 2 rad konplè ou koud ak pwòp men w",
                "Konsèy pou lanse ti mak rad pa w sou rezo sosyal"
            ),
            whatsappPhone = "50937004510",
            whatsappPrefillMessage = "Bonjou ekip Aprann Metye! Mwen ta renmen enskri nan atelye 'Kouti & Mòd' (6,500 HTG). Kijan pou m peye ak MonCash oswa Natcash?"
        ),
        Workshop(
            id = "ws_electrical",
            tradeTitle = "Elektrisite Batiman",
            title = "Fòmasyon Konplè: Elektrisite Kay & Enstalasyon Solè",
            instructorName = "Enj. Mackenson Dorval",
            instructorCredential = "Espesyalis Enèji Solè • 11 lane eksperyans",
            location = "Jakmèl, Okap & Pòtoprens",
            duration = "5 Semèn (Teyori + Montaj Reyèl)",
            priceHtg = 9000,
            nextCohort = "Pwochen Gwoup: 16 Desanm",
            spotsLeft = 5,
            includedItems = listOf(
                "Sètifika Elektrisite & Sistèm Solè",
                "Pratik montaj panno solè, MPPT, batri, ak envètè",
                "Gid kalkil chaj ak chwa disjonktè an Kreyòl",
                "Koneksyon ak konpayi enstalasyon solè lokal yo"
            ),
            whatsappPhone = "50937004510",
            whatsappPrefillMessage = "Bonjou ekip Aprann Metye! Mwen vle patisipe nan fòmasyon 'Elektrisite Batiman & Solè' (9,000 HTG). Tanpri ban m plis enfòmasyon."
        ),
        Workshop(
            id = "ws_barber",
            tradeTitle = "Kwafè & Estetik",
            title = "Mastèklas Salon: Degrade Pafè, Bab & Jesyon Biznis",
            instructorName = "Mèt Kervens 'K-Style' Joseph",
            instructorCredential = "Kwafè Pwofesyonèl • 9 lane eksperyans",
            location = "Pòtoprens (Delma 33)",
            duration = "3 Semèn nan Salon Modèl",
            priceHtg = 5500,
            nextCohort = "Pwochen Gwoup: 9 Desanm",
            spotsLeft = 6,
            includedItems = listOf(
                "Sètifika Mastèklas Kwafè & Ijyèn",
                "Pratik dirèk sou modèl reyèl chak sesyon",
                "Fòmasyon sou esterilizasyon ak fidelizasyon kliyan",
                "Sipò pou monte pòtfolyo foto sou Instagram/TikTok"
            ),
            whatsappPhone = "50937004510",
            whatsappPrefillMessage = "Bonjou ekip Aprann Metye! Mwen ta renmen enskri nan mastèklas 'Kwafè & Estetik' (5,500 HTG). Kijan m ka rezève plas mwen?"
        )
    )
}
