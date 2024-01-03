import com.example.brunonepads.R
import com.example.brunonepads.model.NotasItemModel

class NotasRepository {
    fun obtenerNotas(): List<NotasItemModel> {
        return listOf(
            NotasItemModel(1, "Nota Do", "Nota_C", R.raw.pad_c, R.drawable.c),
            NotasItemModel(2, "Nota Re", "Nota_D", R.raw.pad_c, R.drawable.d),
            NotasItemModel(3, "Nota Mi", "Nota_E", R.raw.pad_c, R.drawable.e),
            NotasItemModel(4, "Nota Fa", "Nota_F", R.raw.pad_c, R.drawable.f),
            NotasItemModel(5, "Nota Sol", "Nota_G", R.raw.pad_c, R.drawable.g),
            NotasItemModel(6, "Nota La", "Nota_A", R.raw.pad_c, R.drawable.a),
            NotasItemModel(7, "Nota Si", "Nota_B", R.raw.pad_c, R.drawable.b),
            NotasItemModel(8, "Nota Do#", "Nota_C#", R.raw.pad_c, R.drawable.c_sos),
            NotasItemModel(9, "Nota Re#", "Nota_D#", R.raw.pad_c, R.drawable.d_sos),
            NotasItemModel(10, "Nota Fa#", "Nota_F#", R.raw.pad_c, R.drawable.f_sos),
            NotasItemModel(11, "Nota Sol#", "Nota_G#", R.raw.pad_c, R.drawable.g_sos),
            NotasItemModel(12, "Nota La#", "Nota_A#", R.raw.pad_c, R.drawable.a_sos)

        )
    }
}
