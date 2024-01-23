import com.example.brunonepads.R
import com.example.brunonepads.model.NotasItemModel

class NotasRepository {
    fun obtenerNotas(): List<NotasItemModel> {
        return listOf(
            NotasItemModel(1, "Nota Do", "Nota_C", R.raw.pad_c, R.drawable.c, R.drawable.c_n),
            NotasItemModel(2, "Nota Re", "Nota_D", R.raw.pad_d, R.drawable.d, R.drawable.d_n),
            NotasItemModel(3, "Nota Mi", "Nota_E", R.raw.pad_e, R.drawable.e, R.drawable.e_n),
            NotasItemModel(4, "Nota Fa", "Nota_F", R.raw.pad_f, R.drawable.f, R.drawable.f_n),
            NotasItemModel(5, "Nota Sol", "Nota_G", R.raw.pad_g, R.drawable.g, R.drawable.g_n),
            NotasItemModel(6, "Nota La", "Nota_A", R.raw.pad_a, R.drawable.a, R.drawable.a_n),
            NotasItemModel(7, "Nota Si", "Nota_B", R.raw.pad_b, R.drawable.b, R.drawable.b_n),
            NotasItemModel(8, "Nota Do#", "Nota_C#", R.raw.pad_c_sos, R.drawable.c_sos, R.drawable.c_sos_n),
            NotasItemModel(9, "Nota Re#", "Nota_D#", R.raw.pad_d_sos, R.drawable.d_sos, R.drawable.d_sos_n),
            NotasItemModel(10, "Nota Fa#", "Nota_F#", R.raw.pad_f_sos, R.drawable.f_sos, R.drawable.f_sos_n),
            NotasItemModel(11, "Nota Sol#", "Nota_G#", R.raw.pad_g_sos, R.drawable.g_sos, R.drawable.g_sus_n),
            NotasItemModel(12, "Nota La#", "Nota_A#", R.raw.pad_a_sos, R.drawable.a_sos, R.drawable.g_sos_n)

        )
    }
}