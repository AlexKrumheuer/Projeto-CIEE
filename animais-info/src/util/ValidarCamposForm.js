export default class ValidarCamposForm {
    static validarTextoVazio(text) {
        if(!text || text.trim().length === 0) return false
        return true
    }

    static validarDuracao(duracao) {
        if(duracao < 0) {
            return false
        }
        return true
    }
}