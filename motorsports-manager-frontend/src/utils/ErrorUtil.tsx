import {ResponseError} from "../generated-sources"

export default class ErrorUtil {
    static retrieveErrorMessage(err: ResponseError, callback: any) {
        err.response.json().then(json => {
            if (json.errors) {
                callback(json.errors[0].defaultMessage);
            }
        });
    }
}