package com.christiano.bolla.styles

import com.christiano.bolla.theme.ColorScheme
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.theme.colors.palette.Palette
import com.varabyte.kobweb.silk.theme.colors.palette.colorMode
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

private enum class LightColorScheme(val hex: String, val rgb: CSSColorValue, val silkRgb: Color) {
    Primary(hex = "#FF4E5B92", rgb = rgb(78, 91, 146), silkRgb = Color.rgb(78, 91, 146)),
    OnPrimary(hex = "#FFFFFFFF", rgb = rgb(255, 255, 255), silkRgb = Color.rgb(255, 255, 255)),
    PrimaryContainer(hex = "#FFDDE1FF", rgb = rgb(221, 225, 255), silkRgb = Color.rgb(221, 225, 255)),
    OnPrimaryContainer(hex = "#FF06164B", rgb = rgb(6, 22, 75), silkRgb = Color.rgb(6, 22, 75)),
    Secondary(hex = "#FF485D92", rgb = rgb(72, 93, 146), silkRgb = Color.rgb(72, 93, 146)),
    OnSecondary(hex = "#FFFFFFFF", rgb = rgb(255, 255, 255), silkRgb = Color.rgb(255, 255, 255)),
    SecondaryContainer(hex = "#FFDAE2FF", rgb = rgb(218, 226, 255), silkRgb = Color.rgb(218, 226, 255)),
    OnSecondaryContainer(hex = "#FF001947", rgb = rgb(0, 25, 71), silkRgb = Color.rgb(0, 25, 71)),
    Tertiary(hex = "#FF475D92", rgb = rgb(71, 93, 146), silkRgb = Color.rgb(71, 93, 146)),
    OnTertiary(hex = "#FFFFFFFF", rgb = rgb(255, 255, 255), silkRgb = Color.rgb(255, 255, 255)),
    TertiaryContainer(hex = "#FFD9E2FF", rgb = rgb(217, 226, 255), silkRgb = Color.rgb(217, 226, 255)),
    OnTertiaryContainer(hex = "#FF001946", rgb = rgb(0, 25, 70), silkRgb = Color.rgb(0, 25, 70)),
    Error(hex = "#FFBA1A1A", rgb = rgb(186, 26, 26), silkRgb = Color.rgb(186, 26, 26)),
    OnError(hex = "#FFFFFFFF", rgb = rgb(255, 255, 255), silkRgb = Color.rgb(255, 255, 255)),
    ErrorContainer(hex = "#FFFFDAD6", rgb = rgb(255, 218, 214), silkRgb = Color.rgb(255, 218, 214)),
    OnErrorContainer(hex = "#FF410002", rgb = rgb(65, 0, 2), silkRgb = Color.rgb(65, 0, 2)),
    Background(hex = "#FFFBF8FF", rgb = rgb(251, 248, 255), silkRgb = Color.rgb(251, 248, 255)),
    OnBackground(hex = "#FF1A1B21", rgb = rgb(26, 27, 33), silkRgb = Color.rgb(26, 27, 33)),
    Surface(hex = "#FFFBF8FF", rgb = rgb(251, 248, 255), silkRgb = Color.rgb(251, 248, 255)),
    OnSurface(hex = "#FF1A1B21", rgb = rgb(26, 27, 33), silkRgb = Color.rgb(26, 27, 33)),
    SurfaceVariant(hex = "#FFE2E1EC", rgb = rgb(226, 225, 236), silkRgb = Color.rgb(226, 225, 236)),
    OnSurfaceVariant(hex = "#FF45464F", rgb = rgb(69, 70, 79), silkRgb = Color.rgb(69, 70, 79)),
    Outline(hex = "#FF767680", rgb = rgb(118, 118, 128), silkRgb = Color.rgb(118, 118, 128)),
    OutlineVariant(hex = "#FFC6C5D0", rgb = rgb(198, 197, 208), silkRgb = Color.rgb(198, 197, 208)),
    Scrim(hex = "#FF000000", rgb = rgb(0, 0, 0), silkRgb = Color.rgb(0, 0, 0)),
    InverseSurface(hex = "#FF2F3036", rgb = rgb(47, 48, 54), silkRgb = Color.rgb(47, 48, 54)),
    InverseOnSurface(hex = "#FFF2F0F7", rgb = rgb(242, 240, 247), silkRgb = Color.rgb(242, 240, 247)),
    InversePrimary(hex = "#FFB7C4FF", rgb = rgb(183, 196, 255), silkRgb = Color.rgb(183, 196, 255)),
    SurfaceDim(hex = "#FFDBD9E0", rgb = rgb(219, 217, 224), silkRgb = Color.rgb(219, 217, 224)),
    SurfaceBright(hex = "#FFFBF8FF", rgb = rgb(251, 248, 255), silkRgb = Color.rgb(251, 248, 255)),
    SurfaceContainerLowest(hex = "#FFFFFFFF", rgb = rgb(255, 255, 255), silkRgb = Color.rgb(255, 255, 255)),
    SurfaceContainerLow(hex = "#FFF4F2FA", rgb = rgb(244, 242, 250), silkRgb = Color.rgb(244, 242, 250)),
    SurfaceContainer(hex = "#FFEFEDF4", rgb = rgb(239, 237, 244), silkRgb = Color.rgb(239, 237, 244)),
    SurfaceContainerHigh(hex = "#FFE9E7EF", rgb = rgb(233, 231, 239), silkRgb = Color.rgb(233, 231, 239)),
    SurfaceContainerHighest(hex = "#FFE3E1E9", rgb = rgb(227, 225, 233), silkRgb = Color.rgb(227, 225, 233))
}

private enum class DarkColorScheme(val hex: String, val rgb: CSSColorValue, val silkRgb: Color) {
    Primary(hex = "#FFB7C4FF", rgb = rgb(183, 196, 255), silkRgb = Color.rgb(183, 196, 255)),
    OnPrimary(hex = "#FF1F2D61", rgb = rgb(31, 45, 97), silkRgb = Color.rgb(31, 45, 97)),
    PrimaryContainer(hex = "#FF364379", rgb = rgb(54, 67, 121), silkRgb = Color.rgb(54, 67, 121)),
    OnPrimaryContainer(hex = "#FFDDE1FF", rgb = rgb(221, 225, 255), silkRgb = Color.rgb(221, 225, 255)),
    Secondary(hex = "#FFB1C5FF", rgb = rgb(177, 197, 255), silkRgb = Color.rgb(177, 197, 255)),
    OnSecondary(hex = "#FF172E60", rgb = rgb(23, 46, 96), silkRgb = Color.rgb(23, 46, 96)),
    SecondaryContainer(hex = "#FF304578", rgb = rgb(48, 69, 120), silkRgb = Color.rgb(48, 69, 120)),
    OnSecondaryContainer(hex = "#FFDAE2FF", rgb = rgb(218, 226, 255), silkRgb = Color.rgb(218, 226, 255)),
    Tertiary(hex = "#FFB1C6FF", rgb = rgb(177, 198, 255), silkRgb = Color.rgb(177, 198, 255)),
    OnTertiary(hex = "#FF162E60", rgb = rgb(22, 46, 96), silkRgb = Color.rgb(22, 46, 96)),
    TertiaryContainer(hex = "#FF2F4578", rgb = rgb(47, 69, 120), silkRgb = Color.rgb(47, 69, 120)),
    OnTertiaryContainer(hex = "#FFD9E2FF", rgb = rgb(217, 226, 255), silkRgb = Color.rgb(217, 226, 255)),
    Error(hex = "#FFFFB4AB", rgb = rgb(255, 180, 171), silkRgb = Color.rgb(255, 180, 171)),
    OnError(hex = "#FF690005", rgb = rgb(105, 0, 5), silkRgb = Color.rgb(105, 0, 5)),
    ErrorContainer(hex = "#FF93000A", rgb = rgb(147, 0, 10), silkRgb = Color.rgb(147, 0, 10)),
    OnErrorContainer(hex = "#FFFFDAD6", rgb = rgb(255, 218, 214), silkRgb = Color.rgb(255, 218, 214)),
    Background(hex = "#FF121318", rgb = rgb(18, 19, 24), silkRgb = Color.rgb(18, 19, 24)),
    OnBackground(hex = "#FFE3E1E9", rgb = rgb(227, 225, 233), silkRgb = Color.rgb(227, 225, 233)),
    Surface(hex = "#FF121318", rgb = rgb(18, 19, 24), silkRgb = Color.rgb(18, 19, 24)),
    OnSurface(hex = "#FFE3E1E9", rgb = rgb(227, 225, 233), silkRgb = Color.rgb(227, 225, 233)),
    SurfaceVariant(hex = "#FF45464F", rgb = rgb(69, 70, 79), silkRgb = Color.rgb(69, 70, 79)),
    OnSurfaceVariant(hex = "#FFC6C5D0", rgb = rgb(198, 197, 208), silkRgb = Color.rgb(198, 197, 208)),
    Outline(hex = "#FF90909A", rgb = rgb(144, 144, 154), silkRgb = Color.rgb(144, 144, 154)),
    OutlineVariant(hex = "#FF45464F", rgb = rgb(69, 70, 79), silkRgb = Color.rgb(69, 70, 79)),
    Scrim(hex = "#FF000000", rgb = rgb(0, 0, 0), silkRgb = Color.rgb(0, 0, 0)),
    InverseSurface(hex = "#FFE3E1E9", rgb = rgb(227, 225, 233), silkRgb = Color.rgb(227, 225, 233)),
    InverseOnSurface(hex = "#FF2F3036", rgb = rgb(47, 48, 54), silkRgb = Color.rgb(47, 48, 54)),
    InversePrimary(hex = "#FF4E5B92", rgb = rgb(78, 91, 146), silkRgb = Color.rgb(78, 91, 146)),
    SurfaceDim(hex = "#FF121318", rgb = rgb(18, 19, 24), silkRgb = Color.rgb(18, 19, 24)),
    SurfaceBright(hex = "#FF38393F", rgb = rgb(56, 57, 63), silkRgb = Color.rgb(56, 57, 63)),
    SurfaceContainerLowest(hex = "#FF0D0E13", rgb = rgb(13, 14, 19), silkRgb = Color.rgb(13, 14, 19)),
    SurfaceContainerLow(hex = "#FF1A1B21", rgb = rgb(26, 27, 33), silkRgb = Color.rgb(26, 27, 33)),
    SurfaceContainer(hex = "#FF1F1F25", rgb = rgb(31, 31, 37), silkRgb = Color.rgb(31, 31, 37)),
    SurfaceContainerHigh(hex = "#FF292A2F", rgb = rgb(41, 42, 47), silkRgb = Color.rgb(41, 42, 47)),
    SurfaceContainerHighest(hex = "#FF34343A", rgb = rgb(52, 52, 58), silkRgb = Color.rgb(52, 52, 58)),
}

val lightColorScheme = ColorScheme(
    primary = LightColorScheme.Primary.silkRgb,
    onPrimary = LightColorScheme.OnPrimary.silkRgb,
    primaryContainer = LightColorScheme.PrimaryContainer.silkRgb,
    onPrimaryContainer = LightColorScheme.OnPrimaryContainer.silkRgb,
    secondary = LightColorScheme.Secondary.silkRgb,
    onSecondary = LightColorScheme.OnSecondary.silkRgb,
    secondaryContainer = LightColorScheme.SecondaryContainer.silkRgb,
    onSecondaryContainer = LightColorScheme.OnSecondaryContainer.silkRgb,
    tertiary = LightColorScheme.Tertiary.silkRgb,
    onTertiary = LightColorScheme.OnTertiary.silkRgb,
    tertiaryContainer = LightColorScheme.TertiaryContainer.silkRgb,
    onTertiaryContainer = LightColorScheme.OnTertiaryContainer.silkRgb,
    error = LightColorScheme.Error.silkRgb,
    onError = LightColorScheme.OnError.silkRgb,
    errorContainer = LightColorScheme.ErrorContainer.silkRgb,
    onErrorContainer = LightColorScheme.OnErrorContainer.silkRgb,
    background = LightColorScheme.Background.silkRgb,
    onBackground = LightColorScheme.OnBackground.silkRgb,
    surface = LightColorScheme.Surface.silkRgb,
    onSurface = LightColorScheme.OnSurface.silkRgb,
    surfaceVariant = LightColorScheme.SurfaceVariant.silkRgb,
    onSurfaceVariant = LightColorScheme.OnSurfaceVariant.silkRgb,
    surfaceTint = LightColorScheme.Primary.silkRgb,
    outline = LightColorScheme.Outline.silkRgb,
    outlineVariant = LightColorScheme.OutlineVariant.silkRgb,
    scrim = LightColorScheme.Scrim.silkRgb,
    inverseSurface = LightColorScheme.InverseSurface.silkRgb,
    inverseOnSurface = LightColorScheme.InverseSurface.silkRgb,
    inversePrimary = LightColorScheme.InversePrimary.silkRgb,
    surfaceDim = LightColorScheme.Surface.silkRgb,
    surfaceBright = LightColorScheme.Surface.silkRgb,
    surfaceContainerLowest = LightColorScheme.Surface.silkRgb,
    surfaceContainerLow = LightColorScheme.Surface.silkRgb,
    surfaceContainer = LightColorScheme.Surface.silkRgb,
    surfaceContainerHigh = LightColorScheme.Surface.silkRgb,
    surfaceContainerHighest = LightColorScheme.Surface.silkRgb,
)

val darkColorScheme = ColorScheme(
    primary = DarkColorScheme.Primary.silkRgb,
    onPrimary = DarkColorScheme.OnPrimary.silkRgb,
    primaryContainer = DarkColorScheme.PrimaryContainer.silkRgb,
    onPrimaryContainer = DarkColorScheme.OnPrimaryContainer.silkRgb,
    secondary = DarkColorScheme.Secondary.silkRgb,
    onSecondary = DarkColorScheme.OnSecondary.silkRgb,
    secondaryContainer = DarkColorScheme.SecondaryContainer.silkRgb,
    onSecondaryContainer = DarkColorScheme.OnSecondaryContainer.silkRgb,
    tertiary = DarkColorScheme.Tertiary.silkRgb,
    onTertiary = DarkColorScheme.OnTertiary.silkRgb,
    tertiaryContainer = DarkColorScheme.TertiaryContainer.silkRgb,
    onTertiaryContainer = DarkColorScheme.OnTertiaryContainer.silkRgb,
    error = DarkColorScheme.Error.silkRgb,
    onError = DarkColorScheme.OnError.silkRgb,
    errorContainer = DarkColorScheme.ErrorContainer.silkRgb,
    onErrorContainer = DarkColorScheme.OnErrorContainer.silkRgb,
    background = DarkColorScheme.Background.silkRgb,
    onBackground = DarkColorScheme.OnBackground.silkRgb,
    surface = DarkColorScheme.Surface.silkRgb,
    onSurface = DarkColorScheme.OnSurface.silkRgb,
    surfaceVariant = DarkColorScheme.SurfaceVariant.silkRgb,
    onSurfaceVariant = DarkColorScheme.OnSurfaceVariant.silkRgb,
    surfaceTint = DarkColorScheme.Primary.silkRgb,
    outline = DarkColorScheme.Outline.silkRgb,
    outlineVariant = DarkColorScheme.OutlineVariant.silkRgb,
    scrim = DarkColorScheme.Scrim.silkRgb,
    inverseSurface = DarkColorScheme.InverseSurface.silkRgb,
    inverseOnSurface = DarkColorScheme.InverseSurface.silkRgb,
    inversePrimary = DarkColorScheme.InversePrimary.silkRgb,
    surfaceDim = DarkColorScheme.Surface.silkRgb,
    surfaceBright = DarkColorScheme.Surface.silkRgb,
    surfaceContainerLowest = DarkColorScheme.Surface.silkRgb,
    surfaceContainerLow = DarkColorScheme.Surface.silkRgb,
    surfaceContainer = DarkColorScheme.Surface.silkRgb,
    surfaceContainerHigh = DarkColorScheme.Surface.silkRgb,
    surfaceContainerHighest = DarkColorScheme.Surface.silkRgb,
)

val Palette.primary get() = if (colorMode.isDark) darkColorScheme.primary else lightColorScheme.primary
val Palette.onPrimary get() = if (colorMode.isDark) darkColorScheme.onPrimary else lightColorScheme.onPrimary
val Palette.secondaryContainer get() = if (colorMode.isDark) darkColorScheme.secondaryContainer else lightColorScheme.secondaryContainer
val Palette.onSecondaryContainer get() = if (colorMode.isDark) darkColorScheme.onSecondaryContainer else lightColorScheme.onSecondaryContainer
val Palette.tertiary get() = if (colorMode.isDark) darkColorScheme.tertiary else lightColorScheme.tertiary
val Palette.onBackground get() = if (colorMode.isDark) darkColorScheme.onBackground else lightColorScheme.onBackground
val Palette.surface get() = if (colorMode.isDark) darkColorScheme.surface else lightColorScheme.surface
val Palette.onSurface get() = if (colorMode.isDark) darkColorScheme.onSurface else lightColorScheme.onSurface
val Palette.outlineVariant get() = if (colorMode.isDark) darkColorScheme.outlineVariant else lightColorScheme.outlineVariant
val Palette.inverseSurface get() = if (colorMode.isDark) darkColorScheme.inverseSurface else lightColorScheme.inverseSurface
val Palette.inverseOnSurface get() = if (colorMode.isDark) darkColorScheme.inverseOnSurface else lightColorScheme.inverseOnSurface
val Palette.inversePrimary get() = if (colorMode.isDark) darkColorScheme.inversePrimary else lightColorScheme.inversePrimary
val Palette.surfaceVariant get() = if (colorMode.isDark) darkColorScheme.surfaceVariant else lightColorScheme.surfaceVariant
val Palette.onSurfaceVariant get() = if (colorMode.isDark) darkColorScheme.onSurfaceVariant else lightColorScheme.onSurfaceVariant
