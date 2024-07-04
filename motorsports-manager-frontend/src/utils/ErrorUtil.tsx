import {ResponseError} from "../generated-sources"

export default class ErrorUtil {
    static retrieveErrorMessage(err: ResponseError, callback: any) {
        err.response.json().then(json => {
            if (json.errors) {
                callback(json.errors[0].defaultMessage);
            } else if (json.message) {
                callback(json.message);
            } else {
                callback("Oeps, er is iets stuk gegaan, je moet Juriaan even bellen, dat is onze PO");
            }
        });
    }
}