package com.christiano.bolla.models

import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res

enum class TestimonialEnum(
    val image: String,
    val fullName: String,
    val profession: String,
    val review: String
) {
    First(
        image = Res.Image.avatar1,
        fullName = "John Doe",
        profession = "Android Developer",
        review = "I am incredibly fortunate to have such an inspiring mentor like Christiano. Their unwavering guidance and insightful advice have been the cornerstone of my professional growth. Their ability to navigate complex challenges with poise and their willingness to share knowledge has truly elevated my skills. Christiano leads with a perfect blend of patience and expertise, making them a true role model. Grateful for the opportunity to learn and be guided by the best!"
    ),
    Second(
        image = Res.Image.avatar2,
        fullName = "Jane Doe",
        profession = "Android Lead",
        review = "Working alongside Christiano has been an absolute privilege. Their tireless dedication to our team's growth and success is truly commendable. Christiano consistently goes above and beyond, readily offering assistance and putting in the effort to ensure our collective progress. As a coworker, their commitment to collaboration and their unwavering support make them an invaluable asset. Grateful to be part of a team led by someone who leads not just by words, but by inspiring actions."
    ),
    Third(
        image = Res.Image.avatar3,
        fullName = "Patrick Star",
        profession = "Developer",
        review = "It's a pleasure to express my admiration for Christiano. Their professionalism, dedication, and positive attitude create an incredible work environment. Christiano's exceptional ability to collaborate and communicate elevates team projects, making even complex tasks seem manageable. Their insightful contributions and willingness to assist showcase their remarkable work ethic. Truly grateful for the opportunity to work alongside someone who consistently sets a high standard for excellence."
    ),
    Fourth(
        image = Res.Image.avatar4,
        fullName = "Sandy Badger",
        profession = "Someone higher up",
        review = "Christiano was an invaluable asset to our team. Their exceptional skills and dedication consistently yielded outstanding results. Their proactive approach to challenges and ability to work harmoniously with colleagues showcased exemplary professionalism. Christiano truly exceeded expectations and significantly contributed to our success."
    ),
    Fifth(
        image = Res.Image.avatar5,
        fullName = "Milena Nesovic",
        profession = "HR Recruiter",
        review = Constants.LOREM_IPSUM_SHORT
    ),
    Sixth(
        image = Res.Image.avatar6,
        fullName = "Aca Rodic",
        profession = "Cyber Security Analyst",
        review = Constants.LOREM_IPSUM_SHORT
    ),
}