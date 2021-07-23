import httpClient from "./api"

const getCursos = function(){
    return httpClient.get("/cursos")
}

export {
    getCursos
}