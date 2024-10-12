package ar.edu.ort.parcialtp3grupo2.sections.home.screens.productDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.home.components.Counter
import ar.edu.ort.parcialtp3grupo2.sections.home.components.ItemRow
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar

var apple = Product(
    id = 1,
    name = "Natural Red Apple",
    price = 4.99,
    amount = "1kg",
    image = R.drawable.apple,
    detail = "Apples are Nutritious. Apples May Be Good For Weight Loss. Apples May Be Good For Your Heart. As Part Of A Healtful And Varied Diet"
)

@Composable
fun ProductDetailScreen(){
    Scaffold(
        topBar = {MyTopAppBar(title = "Product Detail", isArrowBack = true)}
    ) { innerpadding ->
        ProductDetailContent(modifier = Modifier.padding(innerpadding), apple)
    }
}




@Composable
fun ProductDetailContent(modifier: Modifier = Modifier, prod: Product) {
    var counter by remember { mutableStateOf(0) }
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color(0xFFF2F3F2))
                .clip(RoundedCornerShape(10.dp)),
             contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.shareicon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(7.dp)
                    .size(25.dp)
            )
            Image(
                painter = painterResource(id = prod.image),
                contentDescription = null,
                modifier = Modifier
                    .width(329.dp)
                    .height(199.dp)
            )
        }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        ProductDetailBody(prod = prod, counter, onDecrement ={ if (counter > 0) counter-- }, onIncrement = {counter++} )

    }
        GreenButtonRightText(onClick = { }, "Add to Basket" )
    }

}

@Composable
fun ProductDetailBody(prod: Product, counter: Int, onIncrement: () -> Unit, onDecrement: () -> Unit ){

    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = prod.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = "${prod.amount}, Price",
                fontSize = 16.sp,
                color = Color.Gray
            )

        }
        FavIcon()
    }
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(90.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Counter(counter, onIncrement, onDecrement)
        Text(
            text = "$ ${prod.price}",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
    Divider(color = Color.LightGray, thickness = 0.7.dp)
    ProductDetailExpandableRow(title = "Product Detail", detail = prod.detail)
    Divider(color = Color.LightGray, thickness = 0.7.dp)
    ItemRow(label = "Nutritions", 16,  Color.Black,rightContent = R.drawable.gains, 33)
    Divider(color = Color.LightGray, thickness = 0.7.dp)
    ItemRow(label = "Review", 16,  Color.Black,rightContent = R.drawable.stars, 90)
}


@Composable
fun ProductDetailExpandableRow(title: String, detail: String) {
    var isDetailVisible by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 16.sp
        )

        Icon(
            imageVector = if (isDetailVisible) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
            contentDescription = "Toggle Details",
            modifier = Modifier
                .clickable { isDetailVisible = !isDetailVisible }
                .size(24.dp)
        )
    }

    if (isDetailVisible) {
        Text(
            text = detail,
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp),
            fontSize = 13.sp
        )
    }
}


@Composable
fun FavIcon() {
    var isFavorite by remember { mutableStateOf(false) }
    Icon(
        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
        contentDescription = "Favorite",
        modifier = Modifier
            .clickable { isFavorite = !isFavorite }
            .size(24.dp),
        tint = if (isFavorite) Color.Green else Color.Gray
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProductDetail() {
    ProductDetailScreen()
}
