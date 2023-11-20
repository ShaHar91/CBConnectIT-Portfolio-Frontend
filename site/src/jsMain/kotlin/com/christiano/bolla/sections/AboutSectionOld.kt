package com.christiano.bolla.sections

//
//@Composable
//fun AboutSection() {
//    Box(
//        modifier = Modifier
//            .id(Section.About.id)
//            .maxWidth(Constants.SECTION_WIDTH.px)
//            .margin(top = Constants.SECTION_PADDING.px)
//            .padding(top = Constants.SECTION_PADDING.px),
//        contentAlignment = Alignment.Center
//    ) {
//        AboutContent()
//    }
//}
//
//@Composable
//fun AboutContent() {
//    val breakpoint = rememberBreakpoint()
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth(
//                if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent
//            )
//            .maxWidth(1200.px),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        SimpleGrid(
//            modifier = Modifier.fillMaxWidth(
//                if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent
//            ),
//            numColumns = numColumns(base = 1, md = 2)
//        ) {
//            if (breakpoint >= Breakpoint.MD) {
//                AboutImage()
//            }
//            AboutMe()
//        }
//    }
//}
//
//@Composable
//fun AboutImage() {
//    Box(
//        modifier = Modifier.fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            modifier = AboutImageStyle.toModifier().fillMaxWidth(80.percent),
//            src = Res.Image.about,
//            alt = "About Image"
//        )
//    }
//}
//
//@Composable
//fun AboutMe() {
//    val scope = rememberCoroutineScope()
//    var viewportEntered by remember { mutableStateOf(false) }
//    val animatedPercentage = remember { Skill.entries.map { 0 }.toMutableStateList() }
//
//    ObserveViewportEntered(
//        sectionId = Section.About.id,
//        distanceFromTop = 300.0
//    ) {
//        viewportEntered = true
//        Skill.entries.forEach { skill ->
//            scope.launch {
//                animateNumbers(
//                    number = skill.percentage.value.toInt(),
//                    onUpdate = {
//                        animatedPercentage[skill.ordinal] = it
//                    }
//                )
//            }
//        }
//    }
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.Center
//    ) {
//        SectionTitle(section = Section.About)
//
//        P(
//            attrs = Modifier
//                .margin(topBottom = 25.px)
//                .maxWidth(500.px)
//                .fontFamily(Constants.FONT_FAMILY)
//                .fontSize(18.px)
//                .fontWeight(FontWeight.Normal)
//                .toAttrs()
//        ) {
//            Text("Skilled Android Developer with over 5 years of experience in developing applications using Java and Kotlin. Someone who has a passion for staying up-to-date with all new technologies, constantly seeking to explore and take advantage of the latest advancements in the Android Framework. Committed to delivering robust, user-friendly, and scalable applications. A fast learner with an ability to adapt quickly to new technologies and a strong focus for code quality and best practices.")
//        }
//
//        Row {
//            val colorMode by ColorMode.currentState
//
//            Backdrop(colorMode) {
//                Column {
//                    FaAward(
//                        size = IconSize.LG
//                    )
//
//                    P() {
//                        Text("Experience")
//                    }
//
//                    P {
//                        val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
//                        val current = Date.now().toDuration(DurationUnit.MILLISECONDS)
//
//                        val yearsExperience = (current - started).inWholeDays / 365
//
//                        Text("$yearsExperience years")
//                    }
//                }
//            }
//
//            Backdrop(colorMode) {
//                Column {
//                    FaAddressBook(
//                        size = IconSize.LG
//                    )
//
//                    P() {
//                        Text("Experience")
//                    }
//
//                    P {
//                        val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
//                        val current = Date.now().toDuration(DurationUnit.MILLISECONDS)
//
//                        val yearsExperience = (current - started).inWholeDays / 365
//
//                        Text("$yearsExperience years")
//                    }
//                }
//            }
//
//            Backdrop(colorMode) {
//                Column {
//                    FaAward(
//                        size = IconSize.LG
//                    )
//
//                    P() {
//                        Text("Experience")
//                    }
//
//                    P {
//                        val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
//                        val current = Date.now().toDuration(DurationUnit.MILLISECONDS)
//
//                        val yearsExperience = (current - started).inWholeDays / 365
//
//                        Text("$yearsExperience years")
//                    }
//                }
//            }
//        }
//
////        Skill.values().forEach {
////            SkillBar(
////                it.title,
////                it.ordinal,
////                if (viewportEntered) it.percentage else 0.percent,
////                animatedPercentage = if (viewportEntered) animatedPercentage[it.ordinal] else 0
////            )
////        }
//    }
//}