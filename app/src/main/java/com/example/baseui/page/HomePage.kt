package com.example.baseui.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baseui.R
import com.example.baseui.ui.theme.*

class HomePage {
    data class ImageItem(val nameval: String, val resId: Int)

    val bloomBannerList = listOf(
        ImageItem("Desert chic", R.drawable.desert_chic),
        ImageItem("Tiny terrariums", R.drawable.tiny_terrariums),
        ImageItem("Jungle Vibes", R.drawable.jungle_vibes)
    )
    val bloomInfoList = listOf(
        ImageItem("Monstera", R.drawable.monstera),
        ImageItem("Aglaonema", R.drawable.aglaonema),
        ImageItem("Peace lily", R.drawable.peace_lily),
        ImageItem("Fiddle leaf", R.drawable.fiddle_leaf),
        ImageItem("Desert chic", R.drawable.desert_chic),
        ImageItem("Tiny terrariums", R.drawable.tiny_terrariums),
        ImageItem("Jungle Vibes", R.drawable.jungle_vibes)
    )
    val navList = listOf(
        ImageItem("Home", R.drawable.ic_home),
        ImageItem("Favorites", R.drawable.ic_favorite_border),
        ImageItem("Profile", R.drawable.ic_account_circle),
        ImageItem("Cart", R.drawable.ic_shopping_cart),
    )

    @Composable
    fun HomePage() {
        Scaffold(
            bottomBar = {
                BottomBar()
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(white)
                    .padding(horizontal = 16.dp)
            ) {
                SearchBar()
                BloomRowBanner()
                BloomInfoList()
            }
        }
    }

    private @Composable
    fun BottomBar() {
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(pink100)
        ) {
            navList.forEach {
                BottomNavigationItem(
                    selected = ("Home" == it.nameval),
                    onClick = { },
                    icon = {
                        Icon(
                            painter = painterResource(id = it.resId),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = it.nameval,
                            style = caption,
                            color = gray
                        )
                    }
                )
            }
        }
    }


    private @Composable
    fun SearchBar() {
//        TODO("Not yet implemented")
        Box {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .border(BorderStroke(1.dp, Color.Black)),
                leadingIcon = {
                    Icon(
                        painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_search)),
                        contentDescription = "search",
                        modifier = Modifier.size(18.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Search",
                        style = body1,
                        color = gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = white,
                    unfocusedBorderColor = white,
                    focusedBorderColor = white,
                )

            )
        }
    }

    /**
     * 为BloomRowBanner提供子元素模板
     */
    @Composable
    fun PlantCard(plant: ImageItem) {
        Card(
            modifier = Modifier
                .size(136.dp)
                .clip(RoundedCornerShape(4.dp))
        ) {
            Column() {
                Image(
                    painter = painterResource(id = plant.resId),
                    contentScale = ContentScale.Crop,
                    contentDescription = "image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = plant.nameval,
                        style = h2,
                        color = gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                    )
                }
            }
        }
    }

    private @Composable
    fun BloomRowBanner() {
        Column() {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Browse themes",
                    style = h1,
                    color = gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 32.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier.height(36.dp)
            ) {
                items(bloomBannerList.size) {
                    if (it != 0) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    PlantCard(plant = bloomBannerList[it])
                }
            }
        }
    }

    /**
     * 为BloomInfoList提供子元素模板
     */
    @Composable
    fun DesignCard(plant: ImageItem) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = plant.resId),
                contentScale = ContentScale.Crop,
                contentDescription = "image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            text = plant.nameval,
                            style = h2,
                            color = gray,
                            modifier = Modifier.paddingFromBaseline(top = 24.dp)
                        )
                        Text(
                            text = "This is a description",
                            style = body1,
                            color = gray,
                            modifier = Modifier
                        )
                    }
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .size(24.dp),
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = white
                        )
                    )

                }
                Divider(
                    color = gray,
                    modifier = Modifier
                        .padding(top = 16.dp),
                    thickness = 0.5.dp,
                )
            }
        }


    }

    private @Composable
    fun BloomInfoList() {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Design your home garden",
                    style = h1,
                    color = gray,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_filter_list),
                    contentDescription = "filter",
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(bottom = 56.dp)
            ) {
                items(bloomInfoList.size) {
                    if (it != 0) {
                        Spacer(modifier = Modifier.height(8.dp))
                        DesignCard(plant = bloomInfoList[it])
                    }
                }

            }
        }

    }
    @Preview
    @Composable
    fun HomePageLightPreview(){
        HomePage()
    }

}


