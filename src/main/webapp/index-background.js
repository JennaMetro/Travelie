let imgUrls = [
    "https://images.wallpaperscraft.com/image/singapore_reflection_sky_architecture_69287_1920x1080.jpg",
    "https://static.airhelp.com/wp-content/uploads/2016/03/25090422/beautiful-bali-beaches-wallpaper-3.jpg",
    "http://s1.1zoom.me/b8048/487/Sky_Evening_France_Eiffel_Tower_Paris_From_above_520603_1920x1080.jpg",
    "http://architectureimg.com/wp-content/uploads/2017/06/religious-cobblestone-side-street-cathedral-helsinki-coblestone-city-finland-sunset-road-clouds-buildings-free-wallpapers.jpg",
    "https://appleholiday.com/web/media/2635.jpg",
    "https://image.ibb.co/nnhz15/Dubai_Marina_1920x1080.jpg"
]

var count = 0;

$(document).ready(function() {
    $('body').css('background-image', 'url("' + imgUrls[0] + '")');
});

setInterval(function(){
    count++;
    if (count == 6) {
        count = 0;
    }

    $('body').css('background-image', 'url("' + imgUrls[count] + '")');
}, 3000);