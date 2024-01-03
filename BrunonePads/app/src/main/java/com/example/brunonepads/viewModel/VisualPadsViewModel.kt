import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brunonepads.model.SuperNota
import com.example.brunonepads.repository.SuperNotaRepository
import java.io.IOException

class VisualPadsViewModel : ViewModel() {
    // Repositorio para obtener las SuperNotas
    private val superNotaRepository = SuperNotaRepository()

    // LiveData para exponer las SuperNotas
    private val _superNotas = MutableLiveData<List<SuperNota>>()
    val superNotas: LiveData<List<SuperNota>> get() = _superNotas

    // Función para cargar las SuperNotas
    fun cargarSuperNotas() {
        _superNotas.value = superNotaRepository.getSuperNotas()
    }

    fun onNotaClick(supernota: SuperNota, context: Context) {
        // Aquí puedes agregar la lógica para manejar el clic en una SuperNota
        val soundFilePath = supernota.soundFilePath

        // Reproduce el sonido
        playSound(context, soundFilePath)
    }

    private fun playSound(context: Context, soundFilePath: String) {
        val mediaPlayer = MediaPlayer()
        try {
            val uri = Uri.parse("android.resource://${context.packageName}/raw/$soundFilePath")
            mediaPlayer.setDataSource(context, uri)
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
