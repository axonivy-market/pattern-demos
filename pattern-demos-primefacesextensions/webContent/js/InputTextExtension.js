//This is example how to extend existing method init.
PrimeFaces.widget.InputText.prototype.init = function(cfg) {
	this.cfg = cfg;
	this.jq = $(PrimeFaces.escapeClientId(this.cfg.id));
    PrimeFaces.skinInput(this.jq);

     if(this.cfg.counter) {
     	this.counter = this.cfg.counter ? $(PrimeFaces.escapeClientId(this.cfg.counter)) : null;
        this.cfg.counterTemplate = this.cfg.counterTemplate||'{0}';
        this.updateCounter();

        if(this.counter) {
            var $this = this;
            this.jq.on('input.inputtext-counter', function(e) {
                $this.updateCounter();
            });
           }
        }
	
	// In the following lines, we are extending the existing functionality of InputText to check the maximum length not in characters but in bytes,
	// because some characters, such as umlauts, take more than one byte.
	this.normalizeNewlines(this.jq.val());
	var $this = this;
    this.jq.on('keyup.inputtextarea-maxlength', function(e) {
        if(e.currentTarget.maxLength > 0){
			$this.returnColor();
           	while(byteSize(e.currentTarget.value) > e.currentTarget.maxLength) {
           		e.currentTarget.value = e.currentTarget.value.slice(0,-1);
				$this.changeColor();
        		}
            }
     });
}

//This is example how to add new method to widget.
PrimeFaces.widget.InputText = PrimeFaces.widget.InputText.extend({
	//method which change color on red, if we cut from string
	changeColor: function() {
		this.jq.css('background-color', '#e38a8a'); 
	},
	//method which change color on green, if we didn't cut from string
	returnColor: function() {
		this.jq.css('background-color', '#8ae3a3'); 
	}
});

// Helper function for byte size
function byteSize(str) {
    return new Blob([str]).size;
}