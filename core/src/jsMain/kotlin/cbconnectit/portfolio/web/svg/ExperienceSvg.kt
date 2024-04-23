package cbconnectit.portfolio.web.svg

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun experienceSvg(
    fill: CSSColorValue,
    modifier: Modifier = Modifier
) = Svg(attrs = modifier.toAttrs {
    width(20)
    height(24)
    viewBox(0, 0, 20, 24)
}) {
    Path {
        d("M19.7019 13.9019L17.8577 11.0888C17.7619 10.9205 17.714 10.7282 17.69 10.5359C17.3787 7.07369 14.6721 4.30877 11.2231 3.97217C11.295 4.69345 11.0076 5.41474 10.4567 5.89559L9.23518 6.92943L9.6184 8.49222C9.78606 9.16542 9.6184 9.86266 9.18728 10.4156C8.75615 10.9446 8.10947 11.2812 7.41488 11.2812C7.0077 11.2812 6.60053 11.185 6.24126 10.9686L4.87603 10.1271L3.53475 10.9686C3.48685 11.0167 3.41499 11.0408 3.34314 11.0648C3.34314 11.1129 3.34314 11.1369 3.34314 11.185C3.34314 13.5653 4.46885 15.8734 6.24126 17.3881C6.45682 17.5804 6.57658 17.8208 6.57658 18.1093V22.2447C6.57658 22.5813 6.84004 22.8458 7.15141 22.8698L13.3548 23.3988C13.738 23.4228 14.0494 23.1343 14.0494 22.7736V19.8404C14.0494 19.6481 14.2171 19.5038 14.3847 19.5038H16.5404C17.211 19.5038 17.7379 18.9508 17.7379 18.3017V15.3685C17.7379 15.2482 17.8337 15.128 17.9774 15.128H19.0313C19.678 15.1521 20.0612 14.4308 19.7019 13.9019Z")
        fill(fill)
    }
    Path {
        d("M5.28319 8.49215L7.1035 9.59812C7.60647 9.91068 8.25316 9.45386 8.10945 8.87684L7.60647 6.80915C7.55857 6.56873 7.63043 6.30426 7.82204 6.13596L9.45073 4.74147C9.90581 4.35679 9.66629 3.61146 9.06751 3.56337L6.93584 3.39507C6.69632 3.37103 6.45681 3.22678 6.361 2.98635L5.54666 1.01484C5.30714 0.461851 4.5407 0.461851 4.30118 1.01484L3.48684 2.98635C3.39103 3.22678 3.17547 3.37103 2.912 3.39507L0.78033 3.56337C0.181545 3.58742 -0.0579685 4.33274 0.397108 4.71743L2.0258 6.11191C2.21741 6.28021 2.28927 6.54468 2.24136 6.78511L1.73839 8.87684C1.59468 9.45386 2.24136 9.91068 2.74434 9.59812L4.56465 8.49215C4.80416 8.37194 5.06763 8.37194 5.28319 8.49215Z")
        fill(fill)
    }
}